 
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
import f2os.net.springcrud.util.RegistrationValidator;

@Controller
@RequestMapping(value="/regUser")
public class RegistrationController {
   
    RegistrationValidator validator = null;

    public RegistrationValidator getValidator() {
        return validator;
    }

    @Autowired
    public void setValidator(RegistrationValidator validator) {
        this.validator = validator;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String showForm(ModelMap model){
        Customers userRegis = new Customers();
        model.addAttribute("Registration", userRegis);
        return "home";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String processForm(@ModelAttribute(value="Registration") @Valid Customers userRegis, BindingResult result) {
        
        validator.validate(userRegis, result);
        if(result.hasErrors()){
            System.out.println("result from RegistrationController result.hasErrors "+result.getModel().entrySet());
            return "home";
        }else{
            System.out.println("result from RegistrationController no errors"+result.getModel().entrySet());
            return "home";
        }
    }
}

