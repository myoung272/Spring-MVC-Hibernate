package f2os.net.springcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import f2os.net.springcrud.model.Menu;
import f2os.net.springcrud.service.MenuService;
import f2os.net.springcrud.util.SortMenu;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.ServletContext;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/addMenuItem")
public class AddMenuItemController implements ServletContextAware {

    @Autowired
    private MenuService menuService;
    
    private ServletContext servletContext;
    
    @Override // method from interface ServletContextAware
     public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
    
     List<Menu> menu;
    Set<Menu> catList;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("addMenuItem");
        modelAndView.addObject("addItem", new Menu());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processForm(@ModelAttribute Menu addItem) {
        System.out.println("In processForm of AddMenuItemController" + addItem);
        menuService.saveMenuItem(addItem);
        String message = "Menu item:  " + addItem.getItem() + " was successfully added.";
        ModelAndView modelAndView = new ModelAndView("addMenuItem"); // was home
        modelAndView.addObject("message", message);
        modelAndView.addObject("addItem", new Menu());
        // Reload Menu and catList after new menu item added
        menu = menuService.getMenu();
        servletContext.setAttribute("menu", menu);
        catList = (TreeSet) SortMenu.uniqueCategories(menu);
        servletContext.setAttribute("cats", catList);
        
        return modelAndView;
    }

}
