package f2os.net.springcrud.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
  //  @NamedQuery(name = "Menu.findByProductId", query = "SELECT m FROM Menu m WHERE m.productId = :productId"),
    @NamedQuery(name = "Menu.findByCategory", query = "SELECT m FROM Menu m WHERE m.category = :category"),
    @NamedQuery(name = "Menu.findByItem", query = "SELECT m FROM Menu m WHERE m.item = :item"),
    @NamedQuery(name = "Menu.findByDescription", query = "SELECT m FROM Menu m WHERE m.description = :description"),
    @NamedQuery(name = "Menu.findBySize", query = "SELECT m FROM Menu m WHERE m.size = :size"),
    @NamedQuery(name = "Menu.findByPrice", query = "SELECT m FROM Menu m WHERE m.price = :price"),
    @NamedQuery(name = "Menu.findByActive", query = "SELECT m FROM Menu m WHERE m.active = :active")})
public class Menu implements Serializable, Comparable<Menu> {
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_id")
    private Integer productId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CATEGORY")
    private String category;
    
    @Size(max = 100)
    @Column(name = "ITEM")
    private String item;
    
    @Basic(optional = false)
  //  @NotNull
  //  @Size(min = 1, max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Basic(optional = false)
 //   @NotNull
  //  @Size(min = 1, max = 10)
    @Column(name = "SIZE")
    private String size;
 
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;
   
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private int active;
    
    @Transient
    private int quantity = 1;
    
    public Menu() {
    }

    public Menu(Integer productId) {
        this.productId = productId;
    }

    public Menu(Integer productId, String category, String description, String size, BigDecimal price, int active) {
        this.productId = productId;
        this.category = category;
        this.description = description;
        this.size = size;
        this.price = price;
        this.active = active;
    }
    
    public int compareTo(Menu m){
        return category.compareTo(m.getCategory());
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu Item is "+item+ ", productId=" + productId ;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

   
    
}
