/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f2os.net.springcrud.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author Mitch
 */
@Entity
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByRoleId", query = "SELECT r FROM Roles r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "Roles.findByRole", query = "SELECT r FROM Roles r WHERE r.role = :role")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "role_id")
  //  @GeneratedValue(generator="gen")
 //   @GenericGenerator(name="gen", strategy="foreign",parameters=@Parameter(name="property", value="customers"))
    private Integer roleId;
    
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 30)
    @Column(name = "role")
    private String role;
    
    //@JoinColumn(name = "role_id", referencedColumnName = "CUST_ID", insertable = false, updatable = false)
   // @OneToOne(optional = false)
    @OneToOne
    @PrimaryKeyJoinColumn
    private Customers customers;

    public Roles() {
    }

    public Roles(Integer roleId) {
        this.roleId = roleId;
    }

    public Roles(Integer roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "f2os.net.springcrud.model.Roles[ roleId=" + roleId + " ]";
    }
    
}
