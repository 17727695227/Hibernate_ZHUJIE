package com.hibernate.entity.section01;

import javax.persistence.Embeddable;

@Embeddable/* 表示一个嵌入类，这个类在另一个实体类中充当属性*/
public class Address {
	private String postcode;
	private String address;
	private String city;
	
	public Address()
	{
		
	}
	public Address(String postcode, String address, String city) {
		super();
		this.postcode = postcode;
		this.address = address;
		this.city = city;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
