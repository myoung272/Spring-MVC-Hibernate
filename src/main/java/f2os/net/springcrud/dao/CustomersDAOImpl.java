     
package f2os.net.springcrud.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import f2os.net.springcrud.model.Customers;

@Repository
public class CustomersDAOImpl implements CustomersDAO {
    
    @Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
    @SuppressWarnings("unchecked")
	public List<Customers> getCustomers() {
		return getCurrentSession().createQuery("from Customers").list();
	}
        
   /*      public  Menu getMenuItem(Integer productId){
     return (Menu) getCurrentSession().createSQLQuery("SELECT * from menu m where m.product_id = :productId and m.active = 1")
    .addEntity(Menu.class)
    .setParameter("productId", productId).uniqueResult();
     }
  */      
        
       public Customers getUser(String email, String pWord){
           try {
     return (Customers) getCurrentSession().createSQLQuery("SELECT * from customers c where c.email = :email and c.PASSWORD = :pWord")
    .addEntity(Customers.class)
    .setParameter("email", email).setParameter("pWord", pWord).uniqueResult();
           }
           catch(Exception e){
               System.out.println("An error ocured in CustomersDAOImpl.getUser "+e.getMessage()+e.getCause());
           }
           return null;
           }
       
       public void updateCustomers(Customers cust) {
		
		getCurrentSession().update(cust);
		
	}
        public void createCustomer(Customers cust) {
          getCurrentSession().save(cust);
        }
            
        }

