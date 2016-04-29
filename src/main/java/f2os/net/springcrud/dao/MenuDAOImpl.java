 
package f2os.net.springcrud.dao;
import java.util.List;
import f2os.net.springcrud.model.Menu;
import f2os.net.springcrud.model.Orders;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository; 

@Repository
public class MenuDAOImpl implements MenuDAO {
    
      @Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
   // example     
 /*       Query query = session.createSQLQuery(
"select * from stock s where s.stock_code = :stockCode")
.addEntity(Stock.class)
.setParameter("stockCode", "7277");
List result = query.list();
 */       
        @SuppressWarnings("unchecked")
	public List<Menu> getCats() {
  return getCurrentSession().createSQLQuery("SELECT * from menu\n" +
"group by category\n" +
"order by CATEGORY asc").addEntity(Menu.class).list();
	} 
        
     @SuppressWarnings("unchecked")
     public List<Menu> getCatItems(String cat){
     System.out.println("In MenuDAOImpl.getCatItems passed in cat is: "+cat);
     // MY added "and m.active = 0" 2/24/2015
     return getCurrentSession().createSQLQuery("SELECT * from menu m where m.category = :category and m.active = 0")
    .addEntity(Menu.class)
    .setParameter("category", cat).list();
          
     }
     
     public List<Menu> getMenu(){
         // change this to only get active menu items
         
         // MY added "and m.active = 0" 2/24/2015
        return getCurrentSession().createSQLQuery("SELECT * from menu m where m.active = 0")
        .addEntity(Menu.class)
        .list();        
                
    //   return getCurrentSession().createQuery("from Menu").list();
     }
     
     public  Menu getMenuItem(Integer productId){
     return (Menu) getCurrentSession().createSQLQuery("SELECT * from menu m where m.product_id = :productId and m.active = 0")
    .addEntity(Menu.class)
    .setParameter("productId", productId).uniqueResult();
     }
     
      public void saveMenuItem(Menu item) {
		getCurrentSession().save(item);
	}
    
}
