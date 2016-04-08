package f2os.net.springcrud.dao;

import f2os.net.springcrud.model.OrderHours;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderHoursDAOImpl implements OrderHoursDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public OrderHours getOrderHours(int id) {

        OrderHours orderHours = (OrderHours) getCurrentSession().get(OrderHours.class, id);
        return orderHours;
    }

}
