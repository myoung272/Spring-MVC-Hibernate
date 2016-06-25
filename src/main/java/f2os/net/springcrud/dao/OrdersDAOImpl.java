
package f2os.net.springcrud.dao;

import f2os.net.springcrud.model.Orders;
import java.util.Date;
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
     return getCurrentSession().createSQLQuery("SELECT * FROM ORDERS o WHERE o.CUST_ID = :CUST_ID AND (DATE(o.date_entered) = DATE(NOW())) AND o.status in (0,1,2)  ORDER BY o.date_entered desc")
    .addEntity(Orders.class)
    .setParameter("CUST_ID", custId).list();
        }
     
      public List getAllOpenOrders(){
      //SELECT * from menu m where m.category = :category and m.active = 0
         System.out.println("in getAllOpenOrders");
     return getCurrentSession().createSQLQuery("SELECT * FROM ORDERS o WHERE   (o.status = 0 OR o.status = 1)  ORDER BY o.date_entered desc")
    .addEntity(Orders.class).list();
    
        }
      
       public List findOrdersByStatus(int status) {
        String newOrders = "SELECT * FROM ORDERS o WHERE o.status = 0 ORDER BY o.date_entered desc";
        String inProgOrders = "SELECT * FROM ORDERS o WHERE o.status = 1 ORDER BY o.date_entered desc";
        String completedOrdersToday ="SELECT * FROM ORDERS o WHERE o.status = 2 AND (DATE(o.date_complete) = DATE(NOW()))  ORDER BY o.date_entered desc";
         System.out.println("in findOrdersByStatus");
         
         if(status == 0){
     return getCurrentSession().createSQLQuery(newOrders)
    .addEntity(Orders.class).list();
         }
         else if(status == 1){
            return getCurrentSession().createSQLQuery(inProgOrders)
    .addEntity(Orders.class).list(); 
         } 
          else if(status == 2){
            return getCurrentSession().createSQLQuery(completedOrdersToday)
    .addEntity(Orders.class).list(); 
         } 
        
    return null;
        }
      
      public void updateOrderStatus(int status, int id, Date dc){
          getCurrentSession().createSQLQuery("UPDATE orders o set o.status = :status, o.date_complete = :dc where o.ORDER_ID = :id")
             .setParameter("status", status).setParameter("id", id).setParameter("dc", dc).executeUpdate();
         
      }
      
     
    
      public List showOrderDetails(int orderId){
     System.out.println("in top of OrdersDAOImpl.showOrderDetails");    
     return  getCurrentSession().createSQLQuery("SELECT * FROM ORDERS o WHERE o.ORDER_ID = :ORDER_ID")
    .addEntity(Orders.class)
    .setParameter("ORDER_ID", orderId).list();
      }
    
    
}
