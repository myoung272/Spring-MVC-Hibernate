
package f2os.net.springcrud.dao;

import f2os.net.springcrud.model.Orders;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mitch
 */

@Repository
public class OrdersDAOImpl implements OrdersDAO {
    
    @Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
        
        public void saveOrders(Orders orders) {
		getCurrentSession().save(orders);
	}
        
     public List getCustTodayOrders(int custId){
      //SELECT * from menu m where m.category = :category and m.active = 0
         System.out.println("in getCustTodayOrders");
     return getCurrentSession().createSQLQuery("SELECT * FROM ORDERS o WHERE o.CUST_ID = :CUST_ID AND (DATE(o.date_entered) = DATE(NOW())) AND (o.status = 0 OR o.status = 1)  ORDER BY o.date_entered desc")
    .addEntity(Orders.class)
    .setParameter("CUST_ID", custId).list();
        }
      
     
    
      public List showOrderDetails(int orderId){
     System.out.println("in top of OrdersDAOImpl.showOrderDetails");    
     return  getCurrentSession().createSQLQuery("SELECT * FROM ORDERS o WHERE o.ORDER_ID = :ORDER_ID")
    .addEntity(Orders.class)
    .setParameter("ORDER_ID", orderId).list();
      }
    
    
}
