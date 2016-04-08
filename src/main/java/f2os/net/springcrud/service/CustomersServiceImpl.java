 
package f2os.net.springcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import f2os.net.springcrud.dao.CustomersDAO;
import f2os.net.springcrud.model.Customers;

@Service
@Transactional
public class CustomersServiceImpl implements CustomersService {
    
    @Autowired
	private CustomersDAO customersDAO;
    
    
  
    public List<Customers> getCustomers() {
		return customersDAO.getCustomers();  
	}
   
    public Customers getUser(String email, String pWord){
       return customersDAO.getUser(email, pWord);
    }
    
    public void updateCustomers(Customers cust){
        customersDAO.updateCustomers(cust);
    }
}
