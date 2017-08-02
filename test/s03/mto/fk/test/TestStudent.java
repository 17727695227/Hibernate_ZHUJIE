package s03.mto.fk.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.hibernate.entity.section02.Address02;
import com.hibernate.entity.section02.StudentPK;
import com.hibernate.entity.section02.Students02;

import s03.mto.fk.ClassRoom;
import s03.mto.fk.Students;
import s03.oto.fk.IdCard;
import s03.oto.fk.People;

public class TestStudent {

	@Test
	public void testShemaExport()
	{
		//创建hibernate配置对象
		Configuration configuration = new 
				Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry = new 
                  ServiceRegistryBuilder().applySettings(
	               configuration.getProperties()).buildServiceRegistry();
	    //生成sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		SchemaExport export=new SchemaExport(configuration);
		
		export.create(true,true);
	
	}
	@Test
	public void addStudent()
	{
		//创建hibernate配置对象
		Configuration configuration = new 
				Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry = new 
                  ServiceRegistryBuilder().applySettings(
	               configuration.getProperties()).buildServiceRegistry();
	    //生成sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		//创建班级对象
		ClassRoom classRoom1=new ClassRoom("A001","软件工程");
		ClassRoom classRoom2=new ClassRoom("A002","软件工程");
		//创建四个学生对象
		Students s1 = new Students("志伟1", "12345678", "女", "计算机科学与技术");
		Students s2 = new Students("志伟2", "12345678", "女", "计算机科学与技术");
		Students s3 = new Students("志伟3", "12345678", "女", "计算机科学与技术");
		Students s4 = new Students("志伟4", "12345678", "女", "计算机科学与技术");
		
		s1.setClassRoom(classRoom1);
		s2.setClassRoom(classRoom1);
		s3.setClassRoom(classRoom2);
		s4.setClassRoom(classRoom2);
		
		//先保存班级
		session.save(classRoom1);
		session.save(classRoom2);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);		
		
		transaction.commit();
	}
	
}
