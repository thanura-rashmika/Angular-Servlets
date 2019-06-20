package repo.spec.impl;

import entity.Customer;
import repo.spec.CustomerRepo;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepoImpl implements CustomerRepo {
    @Override
    public boolean add(Customer customer) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws SQLException {
        return false;
    }

    @Override
    public Customer search(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        CrudUtil crudUtil = new CrudUtil();
        ResultSet resultSet = crudUtil.executeQuery("SELECT * FROM customer");
        ArrayList<Customer> customers=new ArrayList<>();
        while (resultSet.next()){
            Customer customer=new Customer();
            customer.setCid(resultSet.getInt("cid"));
            customer.setName(resultSet.getString("name"));
            customer.setAddress(resultSet.getString("address"));
            customer.setMobile(resultSet.getString("mobile"));
            customers.add(customer);
        }
        crudUtil.closeConnection();
        return customers;
    }
}
