package f2os.net.springcrud.service;

import f2os.net.springcrud.dao.OrdersDAO;
import f2os.net.springcrud.model.Orders;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mitch
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDAO ordersDAO;

    public void saveOrders(Orders orders) {
        ordersDAO.saveOrders(orders);
    }

    public List<Orders> getCustTodayOrders(int custId) {
        return ordersDAO.getCustTodayOrders(custId);
    }

    public List showOrderDetails(int orderId) {
        return ordersDAO.showOrderDetails(orderId);
    }

    public List getAllOpenOrders() {
        return ordersDAO.getAllOpenOrders();
    }

    public void updateOrderStatus(int status, int id, Date dc) {
        ordersDAO.updateOrderStatus(status, id, dc);
    }

    public List findOrdersByStatus(int status) {
        return ordersDAO.findOrdersByStatus(status);
    }
}
