
package f2os.net.springcrud.service;
import java.util.List;

import f2os.net.springcrud.model.Menu;
public interface MenuService {
    
public List<Menu> getCats();
public List<Menu> getCatItems(String cat);
public  Menu getMenuItem(Integer productId);
 public List<Menu> getMenu();
 public void saveMenuItem(Menu item);
    
}
