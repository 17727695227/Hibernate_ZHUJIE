package com.hibernate.entity.section01;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity(name="s_student")
@Entity
@Table(name="student",schema="hibernate")
public class Students {

	private int id;
	private String username;
	private String phone;
	private String gender;
	private String injor;
	private Address address;
	
	

	public Students()
	{
		
	}
	
	public Students(int id, String username, String phone, String gender, String injor,Address address) {
		super();
		this.id = id;
		this.username = username;
		this.phone = phone;
		this.gender = gender;
		this.injor = injor;
		this.address=address;
	}
	@Id
	public int getId() {
			return id;
		}	
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getInjor() {
		return injor;
	}
	public void setInjor(String injor) {
		this.injor = injor;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
