package model;

public class Delivery {

	
	private int ID;
	private String name ;
	private String phone ;
	private String email ;
	private String Address;
	public int getID() {
		return ID;
	}
	public Delivery(String name, String phone, String email, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		Address = address;
	}
	public Delivery(int iD, String name, String phone, String email, String address) {
		super();
		ID = iD;
		this.name = name;
		this.phone = phone;
		this.email = email;
		Address = address;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
}
