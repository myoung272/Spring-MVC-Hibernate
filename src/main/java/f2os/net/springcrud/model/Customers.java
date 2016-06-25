package f2os.net.springcrud.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import f2os.net.springcrud.util.Validate;


@Entity
@Table(name = "customers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c"),
    @NamedQuery(name = "Customers.findByDateEntered", query = "SELECT c FROM Customers c WHERE c.dateEntered = :dateEntered"),
    @NamedQuery(name = "Customers.findByCustId", query = "SELECT c FROM Customers c WHERE c.custId = :custId"),
    @NamedQuery(name = "Customers.findByFname", query = "SELECT c FROM Customers c WHERE c.fname = :fname"),
    @NamedQuery(name = "Customers.findByLname", query = "SELECT c FROM Customers c WHERE c.lname = :lname"),
    @NamedQuery(name = "Customers.findByStreet", query = "SELECT c FROM Customers c WHERE c.street = :street"),
    @NamedQuery(name = "Customers.findByState", query = "SELECT c FROM Customers c WHERE c.state = :state"),
    @NamedQuery(name = "Customers.findByZip", query = "SELECT c FROM Customers c WHERE c.zip = :zip"),
    @NamedQuery(name = "Customers.findByCity", query = "SELECT c FROM Customers c WHERE c.city = :city"),
    @NamedQuery(name = "Customers.findByPhone", query = "SELECT c FROM Customers c WHERE c.phone = :phone"),
    @NamedQuery(name = "Customers.findByFaxPhone", query = "SELECT c FROM Customers c WHERE c.faxPhone = :faxPhone"),
    @NamedQuery(name = "Customers.findBySmsPhone", query = "SELECT c FROM Customers c WHERE c.smsPhone = :smsPhone"),
    @NamedQuery(name = "Customers.findByEmail", query = "SELECT c FROM Customers c WHERE c.email = :email"),
    @NamedQuery(name = "Customers.findByPassword", query = "SELECT c FROM Customers c WHERE c.password = :password"),
    @NamedQuery(name = "Customers.findByTotalOrders", query = "SELECT c FROM Customers c WHERE c.totalOrders = :totalOrders")})

public class Customers implements Serializable {

    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
   
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_ORDERS")
    private int totalOrders;
   
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
  //  @NotNull
    @Column(name = "date_entered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEntered;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CUST_ID")
    private Integer custId;
    
    @Size(max = 20)
    @NotEmpty(message="First name field is mandatory.")
    @Column(name = "fname")
    private String fname;
    
    @Size(max = 20)
    @NotEmpty(message="Last name field is mandatory.")
    @Column(name = "lname")
    private String lname;
    
    @Size(max = 30)
    @Column(name = "street") 
    @NotEmpty(message="Street field is mandatory.")
    private String street;
    
   // @Basic(optional = false)
   @NotEmpty(message = "State field is mandatory")
    @Size(max = 2)
    @Column(name = "state")
    private String state;
    
    //@Basic(optional = false)
     @NotEmpty(message = "Zip field is mandatory, five digits")
   //  @Length(max=5,min=5,message="Zip code is five digits.")
    
     
   //  @Max(value=5,  message=" @MAX Zip must be five digits")
 //   @NumberFormat(style= Style.NUMBER)
  // @Min(value=5, message="@MIN Zip must be five digits")
 //  @Digits(integer=5, fraction=0, message=" @Digits Zip code must be five digits")
  //  @Range(min=5, max=5, message="range for zip 5") 

    @Length(min = 5, max = 5, message = "Zip must be five digits")
    @Pattern(regexp = "[0-9]+", message="Zip must be 5 digits only 0-9")
    @Column(name = "zip")
    private String zip;
   
    @Size(max = 40)
    @Column(name = "city")
    @NotEmpty(message = "Town field is mandatory")
    private String city;
   
   @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone format, should be as xxx-xxx-xxxx") //if the field contains phone or fax number consider using this annotation to enforce field validation
    //                             /^(?:\(\d{3}\)|\d{3}-)\d{3}-\d{4}$/
   // @Pattern(regexp="/^(?:\\(\\d{3}\\)|\\d{3}-)\\d{3}-\\d{4}$/", message="Invalid phone format, should be as xxx-xxx-xxxx")
    @NotEmpty(message="Phone field is mendatory.") 
  //  @NumberFormat(style= Style.NUMBER)
    private String phone;
   
    @Size(max = 20)
    @Column(name = "fax_phone")
    private String faxPhone;
   
    @Size(max = 20)
    @Column(name = "sms_phone")
    private String smsPhone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    
    @Email(message="email is not a valid email")
    @Column(name = "email")
    @NotEmpty(message="Email field is mandatory.")
    private String email;
    
   
  //  @Size(min = 1, max = 10)
    @Column(name = "PASSWORD")
    @NotEmpty(message="Password field is mandatory.")
    private String password;
    
    @Transient
    @NotEmpty(message="Retype Password field is mandatory.")
    private String rePassword;
    
    
    
    @OneToOne(mappedBy="customers", cascade = CascadeType.ALL)
    private Roles role;
   
    public Customers() {
    }

    public Customers(Integer custId) {
        this.custId = custId;
    }

    public Customers(Integer custId, Date dateEntered, String state, String zip, String password) {
        this.custId = custId;
        this.dateEntered = dateEntered;
        this.state = state;
        this.zip = zip;
        this.password = password;
    }

    public Date getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
  
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaxPhone() {
       
        return faxPhone;
    }

    public void setFaxPhone(String faxPhone) {
        this.faxPhone = faxPhone;
    }

    public String getSmsPhone() {
        return smsPhone;
    }

    public void setSmsPhone(String smsPhone) {
        this.smsPhone = smsPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Integer totalOrders) {
        this.totalOrders = totalOrders;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custId != null ? custId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.custId == null && other.custId != null) || (this.custId != null && !this.custId.equals(other.custId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "f2os.net.springcrud.model.Customers";
    }

   
    /**
     * @return the rePassword
     */
    public String getRePassword() {
        return rePassword;
    }

    /**
     * @param rePassword the rePassword to set
     */
    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    /**
     * @return the role
     */
    public Roles getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Roles role) {
        this.role = role;
    }

  

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

   
    

   
    
}
