package repo;

import repo.spec.impl.CustomerRepoImpl;
import repo.spec.impl.ItemRepoImpl;
import repo.spec.impl.OrderDetailRepoImpl;
import repo.spec.impl.OrderRepoImpl;

public class RepoFactory {
    public enum RepoTypes{
        CUSTOMER,ITEM,ORDERS,ORDER_DETAIL
    }

    public <T>T getRepo(RepoTypes repoTypes) {
        switch (repoTypes){
            case CUSTOMER:
                return (T) new CustomerRepoImpl();
            case ITEM:
                return (T) new ItemRepoImpl();
            case ORDERS:
                return (T) new OrderRepoImpl();
            case ORDER_DETAIL:
                return (T) new OrderDetailRepoImpl();
            default:
                return null;
        }
    }
}
