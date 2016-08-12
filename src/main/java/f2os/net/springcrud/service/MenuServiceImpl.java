
package f2os.net.springcrud.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import f2os.net.springcrud.dao.MenuDAO;
import f2os.net.springcrud.model.Menu;

@Service
@Transactional
public class MenuServiceImpl implements  MenuService {
    
    @Autowired
	private MenuDAO menuDAO;
  
    public List<Menu> getCats() {
    return menuDAO.getCats();  
	}
    
    public List<Menu> getCatItems(String cat){
        return menuDAO.getCatItems(cat);
    }
    
    public List<Menu> getMenu(){
        return menuDAO.getMenu();
    }
    
    public Menu getMenuItem(Integer productId){
        return menuDAO.getMenuItem(productId);
    }
    
    public void saveMenuItem(Menu item) {
        menuDAO.saveMenuItem(item);
    }
    
    public void editMenuItem(Menu item) {
        menuDAO.editMenuItem(item);
    }
     public void removeMenuItem(int id){
         menuDAO.removeMenuItem(id);
     }
            
  
    public  void setAllMenuItemsInactive() {
        menuDAO.setAllMenuItemsInactive();
    }
}
