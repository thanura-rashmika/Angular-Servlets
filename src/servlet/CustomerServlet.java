package servlet;

import dto.CustomerDTO;
import service.ServiceFactory;
import service.spec.CustomerService;
import servlet.other.JsonResponseGenerator;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService=new ServiceFactory().getService(ServiceFactory.ServiceTypes.CUSTOMER);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Working");
        try {
            boolean operation = req.getHeader("operation").isEmpty();
        } catch (NullPointerException n){
            resp.sendError(400,"No operation header is presented ! ");
            return;
        }
        switch (req.getHeader("operation")){
            case "getAll":
                try {
                    resp.setContentType("application/json");
                    JsonArray customerDTOList = new JsonResponseGenerator().getByCustomerDTOList(customerService.getAll());
                    resp.getWriter().println(customerDTOList);
                }catch (RuntimeException r){
                    r.printStackTrace();
                    resp.sendError(HttpServletResponse.SC_EXPECTATION_FAILED,r.getMessage());
                }
                break;
            case "search":
                try {
                    resp.setContentType("application/json");
                    CustomerDTO customerDTO = customerService.search(Integer.parseInt(req.getParameter("cid")));
                    if (customerDTO == null) {
                        resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No customer for given id !");
                        return;
                    }
                    JsonObject byCustomerDTO = new JsonResponseGenerator().getByCustomerDTO(customerDTO);
                    resp.getWriter().println(byCustomerDTO);
                }catch (RuntimeException r){
                    r.printStackTrace();
                    resp.sendError(HttpServletResponse.SC_EXPECTATION_FAILED,r.getMessage());
                }
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Get Operation");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
