
package f2os.net.springcrud.dao;

import f2os.net.springcrud.model.Roles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RolesDAOImpl implements RolesDAO {
    
       @Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
    
    public void createRole(Roles role) {
          getCurrentSession().save(role);
    }
    
}
