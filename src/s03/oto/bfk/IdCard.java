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
	@GeneratedValue(generator="pid")//这里的id不能是自己增长的，所以要指定他的生成器
	@GenericGenerator(name="pid",strategy="assigned")//构建一个生成器，为手工赋值
	@Column(length=18)	
	private String pid;
	private String cid;
	//主控方的配置同一对一单向外键关联
	//另外注意：如果上面配置的实在private上面，这里也是要配置在private上面，否则都配置在get上面
	
	@OneToOne(mappedBy="idCard")//被控方的外键
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
