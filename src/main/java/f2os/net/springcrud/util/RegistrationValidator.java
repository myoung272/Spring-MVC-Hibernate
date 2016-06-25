 
package f2os.net.springcrud.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import f2os.net.springcrud.model.Customers;

@Component
public class RegistrationValidator implements Validator {

    @Override
    public boolean supports(Class c) {
        return Customers.class.isAssignableFrom(c);
    }

    @Override
    public void validate(Object command, Errors errors) {
        Customers regBean = (Customers)command;
        if(!regBean.getPassword().equals(regBean.getRePassword()))
            errors.rejectValue("rePassword","password.notmatch");
           
        }
}