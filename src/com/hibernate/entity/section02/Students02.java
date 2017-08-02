package com.hibernate.entity.section02;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

//@Entity(name="s_student")
@Entity
@Table(name="student",schema="hibernate")
public class Students02 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO) //默认主键自动增长，但是字符串不能
//	private int id;
	//把id改为string类型的时候，@GeneratedValue的使用
	
	/* 使用GeneratedValue设置String的id主键*/
	//@Id
	//@GeneratedValue(strategy=GenerationType.AUTO) //默认主键自动增长，但是字符串不能
	//上面的这个是不对的
	//@GeneratedValue(generator="id")
	//@GenericGenerator(name="id",strategy="assigned")//id跟上一行的id要一样，assigned表示为人工赋值
	//@Column(length=10)
	//private String id;
	
	
	//@EmbeddedId使用嵌入式主键类实现符合主键
	@EmbeddedId
	private StudentPK pk;
	
	//@Id
	//@Column(length=10)
	private String username;
	private String phone;
	private String gender;
	private String injor;
	
	//额外加一个string来测试@Transient不会映射到数据可表里面
	@Transient
	private String good;
	
	public String getGood() {
		return good;
	}

	public void setGood(String good) {
		this.good = good;
	}

	@Embedded
	private Address02 address;
	

	public Students02()
	{
		
	}
	
	public Students02(StudentPK pk, String username, String phone, String gender, String injor,Address02 address) {
		super();
		this.pk = pk;
		this.username = username;
		this.phone = phone;
		this.gender = gender;
		this.injor = injor;
		this.address=address;
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
	public Address02 getAddress() {
		return address;
	}

	public void setAddress(Address02 address) {
		this.address = address;
	}

	public StudentPK getPk() {
		return pk;
	}

	public void setPk(StudentPK pk) {
		this.pk = pk;
	}

	
}
