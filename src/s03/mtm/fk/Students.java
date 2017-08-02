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
	
	//学生和老师构成多对多的关联关系
	//其中一个多方持有另一个多方的集合对象（学生持有老师的集合）
	//创建中间表
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
