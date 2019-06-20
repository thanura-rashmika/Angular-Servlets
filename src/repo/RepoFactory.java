package repo;

public class RepoFactory {
    public enum RepoTypes{
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL
    }

    public <T>T getRepo(RepoTypes repoTypes) {
        /*switch (RepoTypes){
        }*/
    }
}
