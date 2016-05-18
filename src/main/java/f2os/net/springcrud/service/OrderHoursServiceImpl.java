
package f2os.net.springcrud.service;

import f2os.net.springcrud.dao.OrderHoursDAO;
import f2os.net.springcrud.model.OrderHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderHoursServiceImpl implements OrderHoursService {
    
    @Autowired
	private OrderHoursDAO orderHoursDAO;
    
     public OrderHours getOrderHours(int id){
         
         return orderHoursDAO.getOrderHours(id);
     }
     
      public void updateOrderHours(OrderHours oh){
           orderHoursDAO.updateOrderHours(oh);
      }
}
