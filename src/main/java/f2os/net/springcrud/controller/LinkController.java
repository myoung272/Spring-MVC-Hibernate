package f2os.net.springcrud.controller;

import f2os.net.springcrud.model.Menu;
import f2os.net.springcrud.model.OrderHours;
import java.time.LocalDateTime;
import java.util.TreeSet;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"catCache", "dow", "orderTimes"})
public class LinkController {

    TreeSet<Menu> catSet;
    OrderHours orderTimes;
    @Autowired // without @Autowired anotation servletContext was null
    private ServletContext servletContext;

    @RequestMapping(value = "/")
    public ModelAndView showCats() {
        return catsCache();
    }

    @RequestMapping(value = "/index" )
    public ModelAndView showCatsIndex() {
        return catsCache();
    }

    public ModelAndView catsCache() {
        ModelAndView modelAndView = new ModelAndView("home");
        catSet = (TreeSet<Menu>) getServletContext().getAttribute("cats");
        orderTimes = (OrderHours) getServletContext().getAttribute("orderHours");
        LocalDateTime dt = LocalDateTime.now();
        int dow = dt.getDayOfWeek().getValue();
        modelAndView.addObject("orderTimes", orderTimes);
        modelAndView.addObject("dow", dow);
        modelAndView.addObject("catCache", catSet);
        
        return modelAndView;
    }

    /**
     * @return the servletContext
     */
    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

}
