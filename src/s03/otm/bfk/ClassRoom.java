package s03.otm.bfk;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ClassRoom {

	@Id
	@GeneratedValue(generator="tid")
	@GenericGenerator(name="tid",strategy="assigned")
	@Column(length=4)
	
	private String tid;//����
	private String tname;//����
	
	@OneToMany(cascade={CascadeType.ALL},
			    fetch=FetchType.LAZY)//һ����Ϊ������
	@JoinColumn(name="stu_id")
	private Set<Students> set;//һ������ �෽�ļ���
	
	
	public Set<Students> getSet() {
		return set;
	}

	public void setSet(Set<Students> set) {
		this.set = set;
	}

	public ClassRoom()
	{
		
	}
	
	public ClassRoom(String tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}


	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
}
