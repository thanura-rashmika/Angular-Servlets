package repo.spec.impl;

import entity.Orders;
import repo.spec.OrderRepo;

import java.sql.SQLException;
import java.util.List;

public class OrderRepoImpl implements OrderRepo {
    @Override
    public boolean add(Orders orders) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Orders orders) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws SQLException {
        return false;
    }

    @Override
    public Orders search(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public List<Orders> getAll() throws SQLException {
        return null;
    }

    @Override
    public int getLastOId() throws SQLException {
        return 0;
    }
}
