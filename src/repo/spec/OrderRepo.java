package repo.spec;

import entity.Orders;
import repo.SuperRepo;

import java.sql.SQLException;

public interface OrderRepo extends SuperRepo<Orders, Integer> {
    int getLastOId() throws SQLException;
}
