 
package f2os.net.springcrud.container;

/**
 *
 * @author Mitch
 */


public class UserBean {
	
	public UserBean(){}
	
	private String lname;
	private String fname;
	private String role;
	private String town;
	private String street;
	private String state;
	private String zip;
	private String email;
	private String phone;
	private String faxPhone;
	private String smsPhone;
	private String pword;
	private String pword2;
	private int custId;
	private double orderTotal;
	private int totalOrders;
	
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	public String getPword2() {
		return pword2;
	}
	public void setPword2(String pword2) {
		this.pword2 = pword2;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public int getTotalOrders() {
		return totalOrders;
	}
	public void setTotalOrders(int totalOrders) {
		this.totalOrders = totalOrders;
	}
}

