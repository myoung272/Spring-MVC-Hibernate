 
package f2os.net.springcrud.dao;

import f2os.net.springcrud.model.OrderHours;


public interface OrderHoursDAO {
    
     public OrderHours getOrderHours(int id);
     
      public void updateOrderHours(OrderHours oh);
}

