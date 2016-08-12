  package f2os.net.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import f2os.net.springcrud.model.Menu;
import f2os.net.springcrud.model.OrderHours;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.validation.Valid;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired // without @Autowired anotation servletContext was null
    private ServletContext servletContext;

    @RequestMapping(value = "/menuCat/{cat}", method = RequestMethod.GET)
    // @ResponseBody // this was added for AJAX call, does not seem needed
    public @ResponseBody ModelAndView menuCategory(@PathVariable String cat) {
        System.out.println("In MenuController.menuCategory  cat is " + cat);
        ModelAndView modelAndView = new ModelAndView("bootHome");
        List<Menu> menu = (List<Menu>) servletContext.getAttribute("menu");
        List<Menu> menuItems = new ArrayList<>();

        for (Menu m : menu) {
            if (m.getCategory().equalsIgnoreCase(cat)) {
                menuItems.add(m);
            }
        }
        //  System.out.println("menuItems of cat "+cat+ " are "+menuItems);
        modelAndView.addObject("cacheMenu", menuItems);
        return modelAndView;
    }
    
      @RequestMapping(value = "/allMenuItems", method = RequestMethod.GET)
    public ModelAndView allMenuItems() {
        List<Menu> menu = (List<Menu>) servletContext.getAttribute("menu");
        ModelAndView modelAndView = new ModelAndView("addMenuItem");
         modelAndView.addObject("menuList", menu);
         return modelAndView;
    }
    
        
    }

