package s03.oto.bfk.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;


import s03.oto.bfk.IdCard;
import s03.oto.bfk.People;

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
	public void addPeople(){
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
		
		//先生成被控类IdCard
		IdCard idCard = new IdCard("123456789012345679","1234567890");
		
		//再生成一个主控类
		People people = new People(idCard, "nihao", "12121212", "女", "计算机科学与技术");
		
		//记得先保存被控类，再保存主控类
		session.save(idCard);
		session.save(people);
		
		
		transaction.commit();
		
		
	}
}
