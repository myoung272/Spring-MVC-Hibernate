
package f2os.net.springcrud.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByDateEntered", query = "SELECT o FROM Orders o WHERE o.dateEntered = :dateEntered"),
    @NamedQuery(name = "Orders.findByDateComplete", query = "SELECT o FROM Orders o WHERE o.dateComplete = :dateComplete"),
    @NamedQuery(name = "Orders.findByOrderId", query = "SELECT o FROM Orders o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "Orders.findByCustId", query = "SELECT o FROM Orders o WHERE o.custId = :custId"),
    @NamedQuery(name = "Orders.findByTotalOrders", query = "SELECT o FROM Orders o WHERE o.totalOrders = :totalOrders"),
    @NamedQuery(name = "Orders.findByOrderTotal", query = "SELECT o FROM Orders o WHERE o.orderTotal = :orderTotal"),
    @NamedQuery(name = "Orders.findByStatus", query = "SELECT o FROM Orders o WHERE o.status = :status"),
    @NamedQuery(name = "Orders.findByDelivery", query = "SELECT o FROM Orders o WHERE o.delivery = :delivery"),
    @NamedQuery(name = "Orders.findByComments", query = "SELECT o FROM Orders o WHERE o.comments = :comments")})

public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
   // @NotNull
    @Column(name = "date_entered", insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEntered;
    
    @Column(name = "date_complete")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateComplete;
    
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Integer orderId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUST_ID")
    private int custId;
    @Basic(optional = false)
   
    @Column(name = "TOTAL_ORDERS")
    private int totalOrders;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Basic(optional = false)
  //  @NotNull
    @Column(name = "order_total")
    private BigDecimal orderTotal;
   
    @Basic(optional = false)
   // @NotNull
    @Column(name = "status")
    private int status;
    
    @Basic(optional = false)
   // @NotNull
    @Column(name = "delivery")
    private int delivery;
    
    @Size(max = 2000)
    @Column(name = "comments")
    private String comments;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name="ORDER_ID")
    private List<Lineitem> lineitem;
    
  //  @JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID", insertable = false, updatable = false)
    @OneToOne
    @JoinColumn(name="CUST_ID", referencedColumnName = "CUST_ID", insertable = false, updatable = false)
    private Customers customer;

    public Orders() {
    }

    public Orders(Integer orderId) {
        this.orderId = orderId;
    }

    public Orders(Integer orderId, Date dateEntered, int custId, int totalOrders, BigDecimal orderTotal, int status, int delivery) {
        this.orderId = orderId;
        this.dateEntered = dateEntered;
        this.custId = custId;
        this.totalOrders = totalOrders;
        this.orderTotal = orderTotal;
        this.status = status;
        this.delivery = delivery;
    }

    public Date getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public Date getDateComplete() {
        return dateComplete;
    }

    public void setDateComplete(Date dateComplete) {
        this.dateComplete = dateComplete;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

  

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "f2os.net.springcrud.model.Orders[ orderId=" + orderId + " ]";
    }

    /**
     * @return the lineitem
     */
    public List<Lineitem> getLineitem() {
        return lineitem;
    }

    /**
     * @param lineitem the lineitem to set
     */
    public void setLineitem(List<Lineitem> lineitem) {
        this.lineitem = lineitem;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the customer
     */
    public Customers getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

   
    
}
