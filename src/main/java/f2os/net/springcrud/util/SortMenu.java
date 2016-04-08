 
package f2os.net.springcrud.util;

import f2os.net.springcrud.model.Menu;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class SortMenu {
    
    public static Set uniqueCategories(List<Menu> menu){
        Set<Menu> catSet = new TreeSet();
        
        for(Menu m : menu){
            catSet.add(m);
        }
        
        
      return catSet;  
    }
    
}
