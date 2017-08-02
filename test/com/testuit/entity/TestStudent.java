package com.testuit.entity;

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

import s03.oto.fk.IdCard;
import s03.oto.fk.People;

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
		//����hibernate���ö���
		Configuration configuration = new 
				Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry = new 
                  ServiceRegistryBuilder().applySettings(
	               configuration.getProperties()).buildServiceRegistry();
	    //����sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
			
			Address02 address02= new Address02("524409", "�㶫��ҵ��ѧ", "����");
			
		    StudentPK pk = new StudentPK("123456789012345679","1234567890");
			
			Students02 students02 = new Students02(pk, "zhiwei", "123456", "nv ", "���������Ϸ����", address02);
				
			session.save(students02);
			transaction.commit();
	}
	@Test
	public void addPeople(){
		//����hibernate���ö���
		Configuration configuration = new 
				Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry = new 
                  ServiceRegistryBuilder().applySettings(
	               configuration.getProperties()).buildServiceRegistry();
	    //����sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		//�����ɱ�����IdCard
		IdCard idCard = new IdCard("123456789012345679","1234567890");
		
		//������һ��������
		People people = new People(idCard, "nihao", "12121212", "Ů", "�������ѧ�뼼��");
		
		//�ǵ��ȱ��汻���࣬�ٱ���������
		session.save(idCard);
		session.save(people);
		
		
		transaction.commit();
		
		
	}
}
