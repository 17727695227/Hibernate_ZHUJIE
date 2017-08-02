package s03.mtm.fk;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


//@Entity(name="s_student")
@Entity
@Table(name="student",schema="hibernate")
public class Students {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String phone;
	private String gender;
	private String injor;
	
	//ѧ������ʦ���ɶ�Զ�Ĺ�����ϵ
	//����һ���෽������һ���෽�ļ��϶���ѧ��������ʦ�ļ��ϣ�
	//�����м��
	@ManyToMany
	@JoinTable(
		name="teacher_student",
		joinColumns={@JoinColumn(name="stu_id")},
		inverseJoinColumns={@JoinColumn(name="tea_id")}
		)
	private Set<Teachers> set;

	public Students()
	{
		
	}
	
	public Students(String username, String phone, String gender, String injor) {
		super();
		this.username = username;
		this.phone = phone;
		this.gender = gender;
		this.injor = injor;
	}
	
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

	public Set<Teachers> getSet() {
		return set;
	}

	public void setSet(Set<Teachers> set) {
		this.set = set;
	}
	
	
}
