package f2os.net.springcrud.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

 


/**
 *
 * @author Mitch
 */


@Entity
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByCustId", query = "SELECT r FROM Roles r WHERE r.custId = :custId"),
    @NamedQuery(name = "Roles.findByRole", query = "SELECT r FROM Roles r WHERE r.role = :role"),
    @NamedQuery(name = "Roles.findByRolePK", query = "SELECT r FROM Roles r WHERE r.rolePK = :rolePK")})
public class Roles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cust_id")
    private int custId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "role")
    private String role;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_PK")
    private Integer rolePK;

    public Roles() {
    }

    public Roles(Integer rolePK) {
        this.rolePK = rolePK;
    }

    public Roles(Integer rolePK, int custId, String role) {
        this.rolePK = rolePK;
        this.custId = custId;
        this.role = role;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getRolePK() {
        return rolePK;
    }

    public void setRolePK(Integer rolePK) {
        this.rolePK = rolePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolePK != null ? rolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.rolePK == null && other.rolePK != null) || (this.rolePK != null && !this.rolePK.equals(other.rolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "f2os.net.springcrud.model.Roles[ rolePK=" + rolePK + " ]";
    }
    
}
