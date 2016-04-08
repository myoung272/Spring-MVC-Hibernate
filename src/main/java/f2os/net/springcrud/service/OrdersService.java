 package f2os.net.springcrud.service;

import f2os.net.springcrud.model.Orders;
import java.util.List;

/**
 *
 * @author Mitch
 */


public interface OrdersService {
    
    public void saveOrders(Orders orders);
    
    public List<Orders> getCustTodayOrders(int custId);
    
    public List showOrderDetails(int orderId);
}
