package com.oracle.TeaMall.bean;

public class User {
	private int userid;
	private String username;
	private String password;
	private int sex;
	private String phone;
	private String realname;
	private String email;
	private String level;
	private String address;
	private String image;
	private int age;
	private String zipcode;
	public User() {
		super();
	}
	public User(int userid, String username, String password, int sex, String phone, String realname, String email,
			String level, String address, String image, int age,String zipcode) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.phone = phone;
		this.realname = realname;
		this.email = email;
		this.level = level;
		this.address = address;
		this.image = image;
		this.age = age;
		this.zipcode = zipcode;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", sex=" + sex
				+ ", phone=" + phone + ", realname=" + realname + ", email=" + email + ", level=" + level + ", address="
				+ address + ", image=" + image + ", age=" + age + ", zipcode=" + zipcode + "]";
	}
	
	
	
}
