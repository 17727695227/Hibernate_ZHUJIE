package com.hibernate.entity.section02;

import javax.persistence.Embeddable;

@Embeddable/* ��ʾһ��Ƕ���࣬���������һ��ʵ�����г䵱����*/
public class Address02 {
	private String postcode;
	private String address;
	private String city;
	
	public Address02()
	{
		
	}
	public Address02(String postcode, String address, String city) {
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
