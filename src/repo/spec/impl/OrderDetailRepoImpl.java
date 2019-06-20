package repo.spec.impl;

import entity.OrderDetail_PK;
import entity.OrderDetails;
import repo.spec.OrderDetailRepo;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailRepoImpl implements OrderDetailRepo {
    @Override
    public boolean add(OrderDetails orderDetails) throws SQLException {
        return false;
    }

    @Override
    public boolean update(OrderDetails orderDetails) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(OrderDetail_PK orderDetail_pk) throws SQLException {
        return false;
    }

    @Override
    public OrderDetails search(OrderDetail_PK orderDetail_pk) throws SQLException {
        return null;
    }

    @Override
    public List<OrderDetails> getAll() throws SQLException {
        return null;
    }
}
