package f2os.net.springcrud.controller;

import f2os.net.springcrud.model.OrderHours;
import f2os.net.springcrud.model.Orders;
import f2os.net.springcrud.service.OrderHoursService;
import f2os.net.springcrud.service.OrdersService;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController implements ServletContextAware {

    OrderHours orderTimes;

    private Map<String, String> startTimes = new LinkedHashMap<>();
    private Map<String, String> stopTimes = new LinkedHashMap<>();
    private List<Orders> orders = new ArrayList<>();

    //   @Autowired 
    private ServletContext servletContext;

    @Autowired
    private OrderHoursService orderHoursService;
    @Autowired
    private OrdersService ordersService;

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
    @RequestMapping(value = "/adminOrderTimes", method = RequestMethod.GET)
    public String showAdminOrderTimesForm(Model model) {
        // ModelAndView modelAndView = new ModelAndView("admin");
        
        startTimes.put("06:00:00", "6:00 AM");
        startTimes.put("10:00:00", "10:00 AM");
        startTimes.put("10:30:00", "10:30 AM");
        startTimes.put("11:00:00", "11:00 AM");
        startTimes.put("10:30:00", "10:30 AM");
        startTimes.put("12:00:00", "12:00 AM");
        // STOP TIMES
        stopTimes.put("21:00:00", "9:00 PM");
        stopTimes.put("21:30:00", "9:30 PM");
        stopTimes.put("22:00:00", "10:00 PM");
        stopTimes.put("22:30:00", "10:30 PM");
        stopTimes.put("23:00:00", "11:00 PM");
        stopTimes.put("23:30:00", "11:30 PM");
        model.addAttribute("startTimes", startTimes);
        model.addAttribute("stopTimes", stopTimes);
        orderTimes = (OrderHours) getServletContext().getAttribute("orderHours");
        model.addAttribute("orderTimes", orderTimes);
        return "admin";
    }
      
      @RequestMapping(value= "/turnOnOff", method = RequestMethod.GET)
    public ModelAndView turnOnOffOrderTimes() {
    ModelAndView modelAndView = new ModelAndView("adminSettings");
        return modelAndView;
    }

    @RequestMapping(value = "/updateOrderTimes/{id}", method = RequestMethod.POST)
    public ModelAndView updateOrderTimes(@Valid @ModelAttribute("orderTimes") OrderHours orderTimes, BindingResult result, ModelMap model, @PathVariable Integer id) {

        orderHoursService.updateOrderHours(orderTimes);
        orderTimes = orderHoursService.getOrderHours(1);
        servletContext.setAttribute("orderHours", orderTimes);
        orderTimes = (OrderHours) getServletContext().getAttribute("orderHours");
        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("startTimes", startTimes);
        modelAndView.addObject("stopTimes", stopTimes);
        modelAndView.addObject("orderTimes", orderTimes);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/orders")
    public ModelAndView showAllOrders() {
        ModelAndView modelAndView = new ModelAndView("adminOrders");
        orders = ordersService.getAllOpenOrders();
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }
    
    @RequestMapping(value = "/findOrders")
    public ModelAndView findOrders(HttpServletRequest request) {
        int status = Integer.parseInt(request.getParameter("ordersToFind"));
       orders = ordersService.findOrdersByStatus(status);
        ModelAndView modelAndView = new ModelAndView("adminOrders");
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    @RequestMapping(value = "/updateOrder")
    public ModelAndView updateOrderStatus(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("orderId"));
        int status = Integer.parseInt(request.getParameter("orderState"));
        if(status == 2 ) {
       Date dateCompleted = new Date();
        ordersService.updateOrderStatus(status, id, dateCompleted);
          }
        else{
           ordersService.updateOrderStatus(status, id, null); 
        }
        orders = ordersService.getAllOpenOrders();
        ModelAndView modelAndView = new ModelAndView("adminOrders");
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    /**
     * @return the servletContext
     */
    public ServletContext getServletContext() {
        return servletContext;
    }

}
