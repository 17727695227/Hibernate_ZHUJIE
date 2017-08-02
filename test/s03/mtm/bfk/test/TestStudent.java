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
		//����hibernate���ö���
		Configuration configuration = new 
				Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry = new 
                  ServiceRegistryBuilder().applySettings(
	               configuration.getProperties()).buildServiceRegistry();
	    //����sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		SchemaExport export=new SchemaExport(configuration);
		
		export.create(true,true);
	
	}
	
	@Test
	public void addStudent()
	{
		Configuration configuration = new 
				Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry = new 
                  ServiceRegistryBuilder().applySettings(
	               configuration.getProperties()).buildServiceRegistry();
	    //����sessionFactory
		
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		//�����ĸ���ʦ
		Teachers teacher1 = new Teachers("C001","����ʦ");
		Teachers teacher2 = new Teachers("C002","����ʦ");
		Teachers teacher3 = new Teachers("C003","����ʦ");
		Teachers teacher4 = new Teachers("C004","����ʦ");
		
		//�����ĸ�ѧ��
		Students student1 = new Students("С��", "12341234121", "Ů","����");
		Students student2 = new Students("С��", "12341234121", "Ů","����");
		Students student3 = new Students("Сף", "12341234122", "Ů","����");
		Students student4 = new Students("С��", "12341234121", "Ů","����");
		
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
