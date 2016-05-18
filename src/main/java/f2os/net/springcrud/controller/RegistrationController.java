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

@Controller
@RequestMapping(value = "/regUser")
public class RegistrationController {

    @Autowired
    private CustomersService customersService;
    
    @Autowired
    private RolesService rolesService;

    RegistrationValidator validator = null;

    public RegistrationValidator getValidator() {
        return validator;
    }

    @Autowired
    public void setValidator(RegistrationValidator validator) {
        this.validator = validator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        Customers userRegis = new Customers();
        model.addAttribute("Registration", userRegis);
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(@ModelAttribute(value = "Registration") @Valid Customers userRegis, BindingResult result) {
      userRegis.setTotalOrders(0);
      customersService.createCustomer(userRegis);
      Roles role = new Roles();
       role.setRole("customer");
       role.setRoleId(userRegis.getCustId());
       userRegis.setRole(role);
       
       validator.validate(userRegis, result);
        if (result.hasErrors()) {
            System.out.println("result from RegistrationController result.hasErrors " + result.getModel().entrySet());
            return "home";
        } 
        
        else {
             
            System.out.println("result from RegistrationController no errors" + result.getModel().entrySet());
           customersService.updateCustomers(userRegis);
            return "home";
        }
    }
}
