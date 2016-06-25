package f2os.net.springcrud.controller;

import f2os.net.springcrud.model.Customers;
import f2os.net.springcrud.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mitch
 */
@Controller
@SessionAttributes("uBean")
public class LoginController {

    @Autowired
    private CustomersService customersService;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", new Customers());
        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView renderLogin() {
      
         ModelAndView modelAndView = new ModelAndView("home"); // was login
          modelAndView.addObject("user", new Customers());
        System.out.println("get view Name " + modelAndView.getViewName());
        System.out.println("getModel " + modelAndView.getModel());
        return modelAndView;
    }
    
    

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute Customers user, WebRequest request, SessionStatus status) {
    
        String message = "Login failed, check email and password";
        System.out.println("email is " + user.getEmail() + " password is " + user.getPassword());
        ModelAndView modelAndView = new ModelAndView("home");
        try {
         //   userBean = customersService.getUser(user.getEmail(), user.getPassword());
              user = customersService.getUser(user.getEmail(), user.getPassword());
              if(user.getRole().getRole().equalsIgnoreCase("admin")){
           //       ModelAndView view=new ModelAndView("redirect:Customer/Searchform.spring");
                  modelAndView.setViewName("redirect:/admin/orders");
              }
          
        } catch (Exception e) {
            System.out.println("An error ocured in CustomersDAOImpl.getUser " + e.getMessage() + e.getCause());
            modelAndView.addObject("message", message);
            return modelAndView;
        }
        if(user == null){ // user not found
            System.out.println("user after login attempt is null");
            modelAndView.setViewName("home");
             modelAndView.addObject("user", new Customers());
             modelAndView.addObject("message", message);
            boolean ub =  modelAndView.getModel().containsValue("uBean");
            System.out.println(" contains value uBean?  "+ub);
             modelAndView.getModel().remove("uBean");
            modelAndView.getModelMap().remove("uBean");
            ub = modelAndView.getModelMap().containsAttribute("uBean");
            System.out.println(" contains attribute uBean?  "+ub);
            modelAndView.getModelMap().remove("uBean", user);
            
           status.setComplete();
           request.removeAttribute("uBean", WebRequest.SCOPE_SESSION);
            
            return modelAndView;
        }
        
        System.out.println("After try-catach userBean is  "+user.toString());
        System.out.println("After try-catach userBean is  "+user.getFname()+" "+user.getEmail()+" "
        +user.getPassword()+ "role is "+user.getRole());
        // below line adds userBean to the request
     //   modelAndView.addObject("userBean", userBean);
        //Since we are adding userBean to cache we don't need above line userBean is added cache via class anotation @SessionAttributes("uBean")
        modelAndView.addObject("uBean", user);

        return modelAndView;
    }

}
