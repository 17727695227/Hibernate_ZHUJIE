package s03.mtm.bfk.test;

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

import s03.mtm.bfk.Teachers;
import s03.mtm.bfk.Students;

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
		Configuration configuration = new 
				Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry = new 
                  ServiceRegistryBuilder().applySettings(
	               configuration.getProperties()).buildServiceRegistry();
	    //生成sessionFactory
		
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		//创建四个老师
		Teachers teacher1 = new Teachers("C001","张老师");
		Teachers teacher2 = new Teachers("C002","黎老师");
		Teachers teacher3 = new Teachers("C003","黄老师");
		Teachers teacher4 = new Teachers("C004","钟老师");
		
		//创建四个学生
		Students student1 = new Students("小美", "12341234121", "女","销售");
		Students student2 = new Students("小明", "12341234121", "女","销售");
		Students student3 = new Students("小祝", "12341234122", "女","销售");
		Students student4 = new Students("小鬼", "12341234121", "女","销售");
		
		Set<Teachers> set1 = new HashSet<>();
		set1.add(teacher1);
		set1.add(teacher2);
		
		Set<Teachers> set2 = new HashSet<>();
		set2.add(teacher3);
		set2.add(teacher1);
		set2.add(teacher4);
		
		Set<Teachers> set3 = new HashSet<>();
		set3.add(teacher2);
		set3.add(teacher3);
		
		Set<Teachers> set4 = new HashSet<>();
		set4.add(teacher1);
		set4.add(teacher2);
		set4.add(teacher4);
		
		student1.setSet(set1);
		student2.setSet(set2);
		student3.setSet(set3);
		student4.setSet(set4);
		
		session.save(teacher1);
		session.save(teacher2);
		session.save(teacher3);
		session.save(teacher4);
		
		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(student4);
		
		tx.commit();
		
		
		
	}
	
	
}
