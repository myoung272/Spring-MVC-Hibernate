
package f2os.net.springcrud.service;

import f2os.net.springcrud.dao.RolesDAO;
import f2os.net.springcrud.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolesServiceImpl implements RolesService {
    
    @Autowired
    private RolesDAO rolesDAO;
    
 

 public void createRole(Roles role) {
        rolesDAO.createRole(role);
    }    
}
