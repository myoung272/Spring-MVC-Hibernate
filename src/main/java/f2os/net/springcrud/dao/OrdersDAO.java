 
package f2os.net.springcrud.dao;

import f2os.net.springcrud.model.Orders;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mitch
 */


public interface OrdersDAO {
    
    public void saveOrders(Orders orders);
    
    public List getCustTodayOrders(int custId);
    
   public List showOrderDetails(int orderId);
   
   public List getAllOpenOrders();
   
   public void updateOrderStatus(int status, int id, Date dc);
   
   public List findOrdersByStatus(int status);
    
}
