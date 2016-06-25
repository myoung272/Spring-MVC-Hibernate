package f2os.net.springcrud.controller;

import f2os.net.springcrud.container.OrderTotals;
import f2os.net.springcrud.model.Customers;
import f2os.net.springcrud.model.Lineitem;
import f2os.net.springcrud.model.Menu;
import f2os.net.springcrud.model.Orders;
import f2os.net.springcrud.model.OrderHours;
import f2os.net.springcrud.service.CustomersService;
import f2os.net.springcrud.service.MenuService;
import f2os.net.springcrud.service.OrdersService;
import f2os.net.springcrud.util.SendGmailRunnable;
import f2os.net.springcrud.util.SendSmsRunnable;
import f2os.net.springcrud.util.CheckOrderTimes;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
//@RestController
@RequestMapping("/order")
@SessionAttributes("orderLineItems")
public class OrderController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private OrdersService ordersService;
    
    @Autowired
    private CustomersService customerService;
    
     @Autowired // without @Autowired anotation servletContext was null
    private ServletContext servletContext;

    private List<Menu> orderList = new ArrayList<>();
    private Menu m = new Menu();
    private OrderTotals ots;
    
// DISPLAY LIST OF ITEMS FOR ORDER
    @RequestMapping(value = "/orderItems/{id}", method = RequestMethod.GET)
    public String getMenuItem(Model model, @PathVariable String id,   @RequestParam int pQuant ) {
        Logger.getLogger(OrderController.class.getName()).log(Level.INFO, "In OrderController");
        System.out.println("product id from OrderController = " + id);
        // Menu m = new Menu();
        m = menuService.getMenuItem(Integer.parseInt(id));
       // m.setQuantity(model.addAttribute(quantity, m));
        m.setQuantity(pQuant);
        System.out.println("Menu Item is  = " + m.getDescription() + " " + m.getItem() + " " + m.getSize() + " " + m.getPrice() + " " + m.getQuantity()
                + " productId " + m.getProductId());
        System.out.println("orderlist is " + orderList);
        orderList.add(m);

        if (!model.containsAttribute("orderLineItems")) {
            model.addAttribute("orderLineItems", orderList);
        }
        System.out.println("orderList from getMenuItem  is " + orderList);

        return "home"; // return type was string also
     //  return model; 
    }
    // REMOVES ITEM FROM ORDER LIST
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public  String removeMenuItem(Model model, @PathVariable String id) {
        m.setProductId(Integer.parseInt(id));
        orderList.remove(m);
        model.addAttribute("orderLineItems", orderList);
        System.out.println("orderList from removeMenuItem  is " + orderList);
        return "home";
    }
     
    // UPDATES ORDER QUANTITY
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateQuantity(Model model, @PathVariable String id, @RequestParam int updateOrderQuant, @RequestParam int updateIndex) {
        System.out.println("In updateQuantity updateOrderQuant is " + updateOrderQuant);
        System.out.println("In updateQuantity updateIndex is " + updateIndex);
        orderList.get(updateIndex - 1).setQuantity(updateOrderQuant);
        model.addAttribute("orderLineItems", orderList);
        System.out.println("orderList from updateQuantity  is " + orderList);
        return "home";
    }
     // CONFIRM ORDER
    @RequestMapping(value = "/pickDel", method = RequestMethod.GET)
    public String confirmOrder(Model model, @RequestParam String pickOrDel,  @RequestParam int backButton) {
        System.out.println("In OrderController.pickDel()");
        ots = new OrderTotals();
        double total = 0;
        System.out.println("orderlist from confirmOrder " + orderList);
        for (Menu m : orderList) {
            total += (m.getPrice().doubleValue() * m.getQuantity());
        }
        System.out.println("Total order price is " + total);
        if (pickOrDel.equals("Delivery")) {
            ots.setDeliveryCharge(1); // need to  pull from props file   
        }
        ots.setSubTotal(total + ots.getDeliveryCharge());
        ots.setSalesTax(ots.getSubTotal() * .07); // need to  pull from props file
        ots.setTotal(ots.getSubTotal() + ots.getSalesTax());

        System.out.println("Sub Total Is " + ots.getSubTotal() + " Sales tax is " + ots.getSalesTax() + " Total Is " + ots.getTotal());
        if(backButton != 1){
        model.addAttribute("orderTotals", ots);
        }
        System.out.println("model as map " + model.asMap().keySet());
        return "home";
    }
    // DISPLAYS CUSTOMERS ORDER(S) PLACED TODAY
     @RequestMapping(value = "/custOrder", method = RequestMethod.GET)
     public ModelAndView getCustTodayOrders(Model model, HttpSession session) {
         ModelAndView modelAndView = new ModelAndView("home");
          Customers user = (Customers) session.getAttribute("uBean");
          System.out.println("User id is: "+user.getCustId());
          List<Orders> custTodayOrders = new ArrayList();
          custTodayOrders = ordersService.getCustTodayOrders(user.getCustId());
          modelAndView.addObject("custTodayOrders",custTodayOrders);
          System.out.println(custTodayOrders);
          System.out.println("custTodayOrders size: "+custTodayOrders.size());
          for(int i = 0; i < custTodayOrders.size(); i++){
              Orders o = new Orders();
              o = custTodayOrders.get(i);
             System.out.println(o.getOrderId());
             for(int li = 0; li < o.getLineitem().size(); li++){
                 System.out.println("lineitems count for order: "+o.getOrderId()+ " "+o.getLineitem().size());
                 Lineitem lineitem = new Lineitem();
                 lineitem = o.getLineitem().get(li);
                 System.out.println("Lineitem id "+lineitem.getLineItemID());
                 System.out.println(lineitem.getMenu());
             }
          }
         return modelAndView;
     }
     // SHOW SINGLE ORDER DETAILS 
      @RequestMapping(value = "/custOrder/{id}", method = RequestMethod.GET)
     public ModelAndView showOrderDetails(Model model, @PathVariable int id, HttpSession session) {
           Customers user = (Customers) session.getAttribute("uBean");
           ModelAndView modelAndView = new ModelAndView("home");
          
           if(user.getRole().getRole().equalsIgnoreCase("admin")){
            modelAndView.setViewName("adminOrders");
           }
          
          List<Orders> orderDetail = ordersService.showOrderDetails(id);
          System.out.println("from showOrderDetails "+orderDetail);
           modelAndView.addObject("orderDetail",orderDetail);
          return modelAndView;
     }
   
     // SAVE ORDER
    @RequestMapping(value = "/saveOrder/{id}", method = RequestMethod.POST)
    public ModelAndView saveOrder(Model model, @PathVariable int id,@RequestParam String pickOrDel,
    @RequestParam double orderTotal, @RequestParam String comments, @RequestParam String userEmail, HttpSession session) {
         System.out.println("pickOrDel  is" +pickOrDel);
         ModelAndView modelAndView = new ModelAndView("home");
       OrderHours  ohs = (OrderHours) getServletContext().getAttribute("orderHours"); // this bean is loaded into cache at server startup.
        boolean orderOn = CheckOrderTimes.checkOrderTimes(ohs);
        if(orderOn == false){
            String message = "Ordering is not open at this time.";
		modelAndView.addObject("message", message);
                return modelAndView;
        }
       
        //  System.out.println("user eamil is "+userEmail);
        Customers user = (Customers) session.getAttribute("uBean");
        user.setTotalOrders(user.getTotalOrders() + 1);
        user.setRePassword("password");
        customerService.updateCustomers(user);
        ots = new OrderTotals();
        double total = 0;
        System.out.println("orderlist from confirmOrder " + orderList);
        for (Menu m : orderList) {
            total += (m.getPrice().doubleValue() * m.getQuantity());
        }
        if(total < 10 && pickOrDel.startsWith("Del") ){
             String message = "Your order is below the Delivery cost, Please select Pick Up instead";
             modelAndView.addObject("message", message);
            return modelAndView;
        }
        
        System.out.println("Total order price is " + total);
          if (pickOrDel.equals("Delivery")) {
        ots.setDeliveryCharge(1); // need to  pull from props file or admin input page  
         }
         
        ots.setSubTotal(total + ots.getDeliveryCharge());
        ots.setSalesTax(ots.getSubTotal() * .07); // need to  pull from props file
        ots.setTotal(ots.getSubTotal() + ots.getSalesTax());

        System.out.println("Sub Total Is " + ots.getSubTotal() + " Sales tax is " + ots.getSalesTax() + " Total Is " + ots.getTotal());
        modelAndView.addObject("orderTotals", ots);

        System.out.println("custId is " + id);

        List<Lineitem> li = new ArrayList<>();
        List<Menu> placedOrder = new ArrayList<>();

        for (Menu mli : orderList) {
            Lineitem lic = new Lineitem();
            lic.setProductID(mli.getProductId());
            lic.setQuantity(mli.getQuantity());
            li.add(lic);
        }

        Orders order = new Orders();
        order.setCustId(id);
        order.setOrderTotal(new BigDecimal(orderTotal));
        order.setComments(comments);
        int pickDel = 1;
        if(pickOrDel.equalsIgnoreCase("Delivery")){
             pickDel = 0;
        }
        order.setDelivery(pickDel);
        order.setLineitem(li);
        placedOrder.addAll(orderList); // orderlist which is session scoped will be cleared in this method,
        //so we neee a request scoped list for the confirmation to the user 
        System.out.println("placedOrder contains " + placedOrder);
        ordersService.saveOrders(order);
        System.out.println("order id is " + order.getOrderId());
        orderList.clear();
        System.out.println("placedOrder contains " + placedOrder);
        //  model.addAttribute("orderLineItems", orderList);
        modelAndView.addObject("placedOrder", placedOrder);
        modelAndView.addObject("order", order);
        orderList.clear();
        System.out.println("placedOrder contains " + placedOrder);
        String smsNum = "7322410646"; //replace with properties file
        //Send sms to admin in new thread
        Runnable smsJob = new SendSmsRunnable("New Order Received from Super Mario Pizza, Check the web site! order#  " + order.getOrderId(), smsNum);
        Thread smsMessage = new Thread(smsJob);
        smsMessage.setName("sms thread");
          if(ohs.getSmsOn()) { // sms notification
          smsMessage.start();
            }
        Runnable sgmr = new SendGmailRunnable(placedOrder, user, ots, order);
        Thread orderMail = new Thread(sgmr);
        orderMail.start();
     //ots = new  OrderTotals();

        return modelAndView;

        // return "home"; 
    }
    
   
    

    /**
     * @return the servletContext
     */
    public ServletContext getServletContext() {
        return servletContext;
    }

    /**
     * @param servletContext the servletContext to set
     */
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

}
