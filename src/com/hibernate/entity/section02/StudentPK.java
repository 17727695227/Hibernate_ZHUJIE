package com.hibernate.entity.section02;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @EmbeddedIdʹ��Ƕ��ʽ������ʵ�ַ�������
 * @����ʵ��hashCode()�� equals(Object obj)�ķ���
 * @author zhiwei
 *
 */
@Embeddable
public class StudentPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Column(length=18)
	private String cid;//��ʾ���֤
	@Column(length=10)
	private String sid;//��ʾѧ��
	
	public StudentPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentPK(String cid, String sid) {
		super();
		this.cid = cid;
		this.sid = sid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
}
