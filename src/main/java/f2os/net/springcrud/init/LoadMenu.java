package f2os.net.springcrud.init;

import f2os.net.springcrud.model.Menu;
import f2os.net.springcrud.model.OrderHours;
import f2os.net.springcrud.service.MenuService;
import f2os.net.springcrud.service.OrderHoursService;
import f2os.net.springcrud.util.SortMenu;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

@Component
public class LoadMenu implements ApplicationListener<ContextRefreshedEvent>, ServletContextAware {

    @Autowired
    private MenuService menuService;

    
    @Autowired
    private OrderHoursService orderHoursService;

    private ServletContext servletContext;

    List<Menu> menu;
    Set<Menu> catList;
    OrderHours orderHours;

    List<Menu> menuContext;

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        System.out.println("*************** In LoadMenu class ******************");
        menu = menuService.getMenu();
        servletContext.setAttribute("menu", menu);
        catList = (TreeSet) SortMenu.uniqueCategories(menu);
        servletContext.setAttribute("cats", catList);
        System.out.println("****************************************************");
        System.out.println("** catList, menu, orderHours set to ServletContext *");
        System.out.println("****************************************************");

        orderHours = orderHoursService.getOrderHours(1);
        servletContext.setAttribute("orderHours", orderHours);
    }
}
