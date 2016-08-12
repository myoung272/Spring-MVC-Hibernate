 
package f2os.net.springcrud.dao;

import java.util.List;

import f2os.net.springcrud.model.Customers;

public interface CustomersDAO {
    
    public List<Customers> getCustomers();
    
      public List<Customers> getAdminSmsNumbers();
    
    public Customers getUser(String email, String pWord);
    
    public void updateCustomers(Customers cust);
    
    public void createCustomer(Customers cust);
}
