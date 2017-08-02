package s03.oto.bfk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="idCard",schema="hibernate")
public class IdCard {

	@Id
	@GeneratedValue(generator="pid")//�����id�������Լ������ģ�����Ҫָ������������
	@GenericGenerator(name="pid",strategy="assigned")//����һ����������Ϊ�ֹ���ֵ
	@Column(length=18)	
	private String pid;
	private String cid;
	//���ط�������ͬһ��һ�����������
	//����ע�⣺����������õ�ʵ��private���棬����Ҳ��Ҫ������private���棬����������get����
	
	@OneToOne(mappedBy="idCard")//���ط������
	private People people;	

	public IdCard(){
		
	}
	
	
	public IdCard(String pid, String cid) {
		super();
		this.pid = pid;
		this.cid = cid;
	}

	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}

	public People getPeople() {
		return people;
	}


	public void setPeople(People people) {
		this.people = people;
	}

}
