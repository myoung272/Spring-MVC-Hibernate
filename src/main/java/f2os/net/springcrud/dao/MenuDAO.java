
package f2os.net.springcrud.dao;

import f2os.net.springcrud.model.Menu;
import java.util.List;


public interface MenuDAO {
   public List<Menu> getCats(); 
   public List<Menu> getCatItems(String cat);
   public List<Menu> getMenu();
   public  Menu getMenuItem(Integer productId);
   public void saveMenuItem(Menu item);
}
