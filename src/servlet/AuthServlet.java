package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/authenticate")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter writer = resp.getWriter()){
            String userName = req.getParameter("username");
            String password = req.getParameter("password");
            System.out.println(userName);
            System.out.println(password);

            if(userName == null || password == null) {
                resp.sendError(401);
                return;
            }

            if(userName.equals("admin") && password.equals("admin")) {
                resp.setStatus(200);
                writer.println("<h1>Authenticated</h1>");
                writer.close();
                req.getSession();
            } else {
                resp.sendError(401);
            }
        }
    }
}
