
package f2os.net.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import f2os.net.springcrud.model.Customers;
import f2os.net.springcrud.service.CustomersService;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value="/customers")
public class CustomerController {
    
    @Autowired
	private CustomersService customersService;
    
    @RequestMapping(value="/list")
	public ModelAndView listOfCustomers() {
		ModelAndView modelAndView = new ModelAndView("customers");
		
		List<Customers> custs = customersService.getCustomers();
		modelAndView.addObject("custs", custs);
		
		return modelAndView;
	}
        
 /*     @RequestMapping(method = RequestMethod.GET, value = "/list")
        public String LogoHeader(Model model) {
       System.out.println("In CustomerController ");
        return "LogoHeader";
}
        */
       
     
    
}
