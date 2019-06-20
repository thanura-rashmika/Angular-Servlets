package repo.spec.impl;

import entity.Customer;
import repo.spec.CustomerRepo;

import java.sql.SQLException;
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
        return null;
    }
}
