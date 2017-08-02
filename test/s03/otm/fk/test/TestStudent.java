package s03.otm.fk.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import s03.otm.fk.ClassRoom;
import s03.otm.fk.Students;
/**
 * 一对多单向关联
 */
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
		
		Set<Students> set1 = new HashSet<>();
		set1.add(s1);
		set1.add(s2);
		
		Set<Students> set2 = new HashSet<>();
		set2.add(s3);
		set2.add(s4);
		
		classRoom1.setSet(set1);
		classRoom2.setSet(set2);	
		//先保存学生
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		
		session.save(classRoom1);
		session.save(classRoom2);
		
				
		
		transaction.commit();
	}
	
}
