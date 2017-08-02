package s03.mtm.bfk;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Teachers {

	@Id
	@GeneratedValue(generator="t_id")
	@GenericGenerator(name="t_id",strategy="assigned")
	@Column(length=4)
	private String tea_id;
	private String tea_name;
	
	@ManyToMany(mappedBy="set")//说明吧主控方交给学生进行管理
	private Set<Students> set;
	
	public Teachers()
	{
		
	}
	
	
	public Teachers(String tea_id, String tea_name) {
		super();
		this.tea_id = tea_id;
		this.tea_name = tea_name;
	}


	public String getTea_id() {
		return tea_id;
	}
	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}
	public String getTea_name() {
		return tea_name;
	}
	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}


	public Set<Students> getSet() {
		return set;
	}


	public void setSet(Set<Students> set) {
		this.set = set;
	}
	
}
