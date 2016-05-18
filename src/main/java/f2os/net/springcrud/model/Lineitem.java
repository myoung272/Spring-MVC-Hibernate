package f2os.net.springcrud.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;




/**
 *
 * @author Mitch
 */


@Entity
@Table(name = "lineitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineitem.findAll", query = "SELECT l FROM Lineitem l"),
    @NamedQuery(name = "Lineitem.findByLineItemID", query = "SELECT l FROM Lineitem l WHERE l.lineItemID = :lineItemID"),
    @NamedQuery(name = "Lineitem.findByOrderID", query = "SELECT l FROM Lineitem l WHERE l.orderID = :orderID"),
    @NamedQuery(name = "Lineitem.findByInvoiceID", query = "SELECT l FROM Lineitem l WHERE l.invoiceID = :invoiceID"),
    @NamedQuery(name = "Lineitem.findByProductID", query = "SELECT l FROM Lineitem l WHERE l.productID = :productID"),
    @NamedQuery(name = "Lineitem.findByQuantity", query = "SELECT l FROM Lineitem l WHERE l.quantity = :quantity")})
public class Lineitem implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "LineItemID")
    private Integer lineItemID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDER_ID")
    private int orderID;
    @Basic(optional = false)
    
    @Column(name = "InvoiceID")
    private int invoiceID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    
    @OneToOne(cascade = {CascadeType.ALL})
  //  @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="product_id",referencedColumnName = "product_id", insertable = false, updatable = false)
    private Menu menu;

    public Lineitem() {
    }

    public Lineitem(Integer lineItemID) {
        this.lineItemID = lineItemID;
    }

    public Lineitem(Integer lineItemID, int orderID, int invoiceID, int productID, int quantity) {
        this.lineItemID = lineItemID;
        this.orderID = orderID;
        this.invoiceID = invoiceID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public Integer getLineItemID() {
        return lineItemID;
    }

    public void setLineItemID(Integer lineItemID) {
        this.lineItemID = lineItemID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lineItemID != null ? lineItemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineitem)) {
            return false;
        }
        Lineitem other = (Lineitem) object;
        if ((this.lineItemID == null && other.lineItemID != null) || (this.lineItemID != null && !this.lineItemID.equals(other.lineItemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "f2os.net.springcrud.model.Lineitem[ lineItemID=" + lineItemID + " ]";
    }

    /**
     * @return the menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

  
    
}
