package com.hxh.domin;

public class User {
	private Integer id;
	private String name;
	private char sex;
	private String phonenumber;
	private String email;
	private String member;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "UserList [id=" + id + ", name=" + name + ", sex=" + sex + ", phonenumber=" + phonenumber + ", email="
				+ email + ", member=" + member + "]";
	}
	

}
