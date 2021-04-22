package bean;

public class User {
private String username,userpass,email,telephone,company,address;
private int role;
public User() {
	// TODO Auto-generated constructor stub
}
public User(String username, String userpass, String email, String telephone,
		String company, String address, int role) {
	super();
	this.username = username;
	this.userpass = userpass;
	this.email = email;
	this.telephone = telephone;
	this.company = company;
	this.address = address;
	this.role = role;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserpass() {
	return userpass;
}
public void setUserpass(String userpass) {
	this.userpass = userpass;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}


}
