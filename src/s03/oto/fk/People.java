package s03.oto.fk;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="people",schema="hibernate")
//schema表示一种模式，可以不一样，这样的好处是防止数据表名称冲突（hibernate.people）
public class People{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	private String username;
	private String phone;
	private String gender;
	private String injor;
	
	@OneToOne(cascade=CascadeType.ALL)//级联全部
	@JoinColumn(name="pid",unique=true)//外键pid，唯一
	private IdCard idCard;
	
	

	public People(IdCard idCard,String username, String phone, String gender, String injor) {
		this.idCard=idCard;
		this.username = username;
		this.phone = phone;
		this.gender = gender;
		this.injor = injor;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	
}
