package f2os.net.springcrud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import f2os.net.springcrud.model.Customers;
import f2os.net.springcrud.model.Roles;
import f2os.net.springcrud.service.CustomersService;
import f2os.net.springcrud.service.RolesService;
import f2os.net.springcrud.util.RegistrationValidator;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Validator;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/regUser")
public class RegistrationController {

    @Autowired
    private CustomersService customersService;

    @Autowired
    private RolesService rolesService;
    
    @Autowired // without @Autowired anotation servletContext was null
    private ServletContext servletContext;

    //  RegistrationValidator validator = null;
    private RegistrationValidator validator;

    public RegistrationValidator getValidator() {
        return validator;
    }

    @Autowired
    public void setValidator(RegistrationValidator validator) {
        this.validator = validator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(ModelMap model, HttpSession session) {
       Customers userRegis = (Customers) session.getAttribute("uBean");
       
       if(userRegis == null){
           userRegis = new Customers();
    }
        model.addAttribute("Registration", userRegis);
        return "bootHome";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processForm(@ModelAttribute(value = "Registration") @Valid Customers userRegis, BindingResult result) {
        ModelAndView mav = new ModelAndView("bootHome");
        if (result.hasErrors()) {
            return mav;
        }
        validator.validate(userRegis, result);
        if (result.hasErrors()) {
            System.out.println("result from RegistrationController result.hasErrors " + result.getModel().entrySet());
            return mav;
        } else {
            userRegis.setTotalOrders(0);
            customersService.createCustomer(userRegis);
            Roles role = new Roles();
            role.setRole("customer");
            role.setRoleId(userRegis.getCustId());
            userRegis.setRole(role);
            System.out.println("result from RegistrationController no errors" + result.getModel().entrySet());
            customersService.updateCustomers(userRegis);
            return mav;
          
        }
    }
}
