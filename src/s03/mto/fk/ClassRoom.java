package s03.mto.fk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ClassRoom {

	@Id
	@GeneratedValue(generator="tid")
	@GenericGenerator(name="tid",strategy="assigned")
	@Column(length=4)
	
	private String tid;//¹¤ºÅ
	private String tname;//ÐÕÃû
	
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
