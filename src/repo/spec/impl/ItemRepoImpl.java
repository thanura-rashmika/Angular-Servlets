package repo.spec.impl;

import entity.Item;
import repo.spec.ItemRepo;

import java.sql.SQLException;
import java.util.List;

public class ItemRepoImpl implements ItemRepo {
    @Override
    public boolean add(Item item) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Item item) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws SQLException {
        return false;
    }

    @Override
    public Item search(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public List<Item> getAll() throws SQLException {
        return null;
    }
}
