package f2os.net.springcrud.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

 


/**
 *
 * @author Mitch
 */


@Entity
@Table(name = "order_hours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderHours.findAll", query = "SELECT o FROM OrderHours o")})
public class OrderHours implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "mo")
 //   @Temporal(TemporalType.TIME)
    private Time mo;
    @Column(name = "tu")
//    @Temporal(TemporalType.TIME)
    private Time tu;
    @Column(name = "we")
//    @Temporal(TemporalType.TIME)
    private Time we;
    @Column(name = "tr")
//    @Temporal(TemporalType.TIME)
    private Time tr;
    @Column(name = "fr")
//    @Temporal(TemporalType.TIME)
    private Time fr;
    @Column(name = "sa")
//    @Temporal(TemporalType.TIME)
    private Time sa;
    @Column(name = "su")
  //  @Temporal(TemporalType.TIME)
    private Time su;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fmo")
  //  @Temporal(TemporalType.TIME)
    private Time fmo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ftu")
  //  @Temporal(TemporalType.TIME)
    private Time ftu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fwe")
  //  @Temporal(TemporalType.TIME)
    private Time fwe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ftr")
  //  @Temporal(TemporalType.TIME)
    private Time ftr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ffr")
 //   @Temporal(TemporalType.TIME)
    private Time ffr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fsa")
 //   @Temporal(TemporalType.TIME)
    private Time fsa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fsu")
 //   @Temporal(TemporalType.TIME)
    private Time fsu;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "on")
    private boolean on;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sms_on")
    private boolean smsOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fax_on")
    private boolean faxOn;
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
     private Integer id;

    public OrderHours() {
    }

    public OrderHours(Integer id) {
        this.id = id;
    }

    public OrderHours(Integer orderHoursId, Time fmo, Time ftu, Time fwe, Time ftr, Time ffr, Time fsa, Time fsu,  boolean on, boolean smsOn, boolean faxOn) {
        this.id = id;
        this.fmo = fmo;
        this.ftu = ftu;
        this.fwe = fwe;
        this.ftr = ftr;
        this.ffr = ffr;
        this.fsa = fsa;
        this.fsu = fsu;
       
        this.on = on;
        this.smsOn = smsOn;
        this.faxOn = faxOn;
    }

    public Time getMo() {
        return mo;
    }

    public void setMo(Time mo) {
        this.mo = mo;
    }

    public Time getTu() {
        return tu;
    }

    public void setTu(Time tu) {
        this.tu = tu;
    }

    public Time getWe() {
        return we;
    }

    public void setWe(Time we) {
        this.we = we;
    }

    public Time getTr() {
        return tr;
    }

    public void setTr(Time tr) {
        this.tr = tr;
    }

    public Time getFr() {
        return fr;
    }

    public void setFr(Time fr) {
        this.fr = fr;
    }

    public Time getSa() {
        return sa;
    }

    public void setSa(Time sa) {
        this.sa = sa;
    }

    public Time getSu() {
        return su;
    }

    public void setSu(Time su) {
        this.su = su;
    }

    public Time getFmo() {
        return fmo;
    }

    public void setFmo(Time fmo) {
        this.fmo = fmo;
    }

    public Time getFtu() {
        return ftu;
    }

    public void setFtu(Time ftu) {
        this.ftu = ftu;
    }

    public Time getFwe() {
        return fwe;
    }

    public void setFwe(Time fwe) {
        this.fwe = fwe;
    }

    public Time getFtr() {
        return ftr;
    }

    public void setFtr(Time ftr) {
        this.ftr = ftr;
    }

    public Time getFfr() {
        return ffr;
    }

    public void setFfr(Time ffr) {
        this.ffr = ffr;
    }

    public Time getFsa() {
        return fsa;
    }

    public void setFsa(Time fsa) {
        this.fsa = fsa;
    }

    public Time getFsu() {
        return fsu;
    }

    public void setFsu(Time fsu) {
        this.fsu = fsu;
    }

    

    public boolean getOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public boolean getSmsOn() {
        return smsOn;
    }

    public void setSmsOn(boolean smsOn) {
        this.smsOn = smsOn;
    }

    public boolean getFaxOn() {
        return faxOn;
    }

    public void setFaxOn(boolean faxOn) {
        this.faxOn = faxOn;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHours)) {
            return false;
        }
        OrderHours other = (OrderHours) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "f2os.net.springcrud.model.OrderHours[ orderHoursId=" + getId() + " ]";
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
}
