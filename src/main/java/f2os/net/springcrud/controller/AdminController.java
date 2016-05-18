
package f2os.net.springcrud.controller;

import f2os.net.springcrud.model.OrderHours;
import f2os.net.springcrud.service.OrderHoursService;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController implements ServletContextAware {
    
    OrderHours orderTimes;
    
 //   @Autowired 
     private ServletContext servletContext;
     
     @Autowired
    private OrderHoursService orderHoursService;
    
    @Override // method from interface ServletContextAware
     public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
     
/*       @RequestMapping(value= "/adminOrderTimes", method = RequestMethod.GET)
    public ModelAndView showAdminOrderTimesForm() {
        ModelAndView modelAndView = new ModelAndView("admin");
        orderTimes = (OrderHours) getServletContext().getAttribute("orderHours");
         modelAndView.addObject("orderTimes", orderTimes);
        return modelAndView;
    }
     */
     
     @RequestMapping(value= "/adminOrderTimes", method = RequestMethod.GET)
    public String showAdminOrderTimesForm(Model model) {
       // ModelAndView modelAndView = new ModelAndView("admin");
        orderTimes = (OrderHours) getServletContext().getAttribute("orderHours");
        model.addAttribute("orderTimes", orderTimes);
        return "admin";
    }
    
      @RequestMapping(value= "/updateOrderTimes", method = RequestMethod.POST)
    public ModelAndView updateOrderTimes(@ModelAttribute("orderTimes")   Model model) {
        orderHoursService.updateOrderHours(orderTimes);
         orderTimes = orderHoursService.getOrderHours(1);
          servletContext.setAttribute("orderHours", orderTimes);
        orderTimes = (OrderHours) getServletContext().getAttribute("orderHours");
          ModelAndView modelAndView = new ModelAndView("admin");
         modelAndView.addObject("orderTimes", orderTimes);
        return modelAndView;
    }

    /**
     * @return the servletContext
     */
    public ServletContext getServletContext() {
        return servletContext;
    }
    
}
