package service.spec.impl;

import db.DBConnection;
import dto.OrderDTO;
import dto.OrderDetailDTO;
import entity.Item;
import entity.OrderDetail_PK;
import entity.OrderDetails;
import entity.Orders;
import org.modelmapper.ModelMapper;
import repo.RepoFactory;
import repo.spec.ItemRepo;
import repo.spec.OrderDetailRepo;
import repo.spec.OrderRepo;
import service.spec.OrderService;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;

public class OrderServiceimpl implements OrderService {
    private OrderRepo orderRepo;
    private OrderDetailRepo orderDetailRepo;
    private ItemRepo itemRepo;
    private ModelMapper modelMapper;

    public OrderServiceimpl() {
        this.orderRepo=new RepoFactory().getRepo(RepoFactory.RepoTypes.ORDERS);
        this.orderDetailRepo=new RepoFactory().getRepo(RepoFactory.RepoTypes.ORDER_DETAIL);
        this.itemRepo=new RepoFactory().getRepo(RepoFactory.RepoTypes.ITEM);
        this.modelMapper=new ModelMapper();
    }

    @Override
    public boolean add(OrderDTO orderDTO)  {
        try {
            Connection connection = DBConnection.getConnection();
            Objects.requireNonNull(connection).setAutoCommit(false);
            try {
                Orders orders = modelMapper.map(orderDTO, Orders.class);
                boolean add = orderRepo.add(orders);
                if (!add) {
                    connection.rollback();
                    return false;
                }
                int lastOrderId = orderRepo.getLastOId();
                for (OrderDetailDTO orderDetailDTO : orderDTO.getOrderDetailDTOList()) {
                    OrderDetails orderDetails = new OrderDetails();
                    orderDetails.setOrderDetail_pk(
                            new OrderDetail_PK(
                                    orderDetailDTO.getOdid(),
                                    lastOrderId
                            )
                    );
                    orderDetails.setUnitPrice(orderDetailDTO.getUnit_price());
                    orderDetails.setQty(orderDetailDTO.getQty());
                    add = orderDetailRepo.add(orderDetails);
                    if (!add) {
                        connection.rollback();
                        return false;
                    }
                    Item item = itemRepo.search(orderDetailDTO.getOdid());
                    item.setQty_on_hand(item.getQty_on_hand() - orderDetailDTO.getQty());
                    add = itemRepo.update(item);
                    if (!add) {
                        connection.rollback();
                        return false;
                    }
                }

                connection.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                connection.rollback();
                return false;
            } finally {
                connection.setAutoCommit(true);
                connection.close();
            }
        }catch (Exception s){
            s.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(OrderDTO orderDTO) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public OrderDTO search(Integer integer) {
        return null;
    }

    @Override
    public List<OrderDTO> getAll() {
        return null;
    }
}
