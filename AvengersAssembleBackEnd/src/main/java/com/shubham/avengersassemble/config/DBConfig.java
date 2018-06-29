package com.shubham.avengersassemble.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shubham.avengersassemble.model.Blog;
import com.shubham.avengersassemble.model.BlogComment;
import com.shubham.avengersassemble.model.Forum;
import com.shubham.avengersassemble.model.ForumComment;
import com.shubham.avengersassemble.model.FriendDetail;
import com.shubham.avengersassemble.model.JobDetail;
import com.shubham.avengersassemble.model.UserDetail;

@Configuration
@ComponentScan("com.shubham")
@EnableTransactionManagement
public class DBConfig 
{
	//----------Data Source Object----------
	public DataSource getDataSource() 
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("avengers");
		dataSource.setPassword("pass@123");
		return dataSource;
	}

	//----------Create SessionFactory Bean----------
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() 
	{

		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.hbmddl2.auto", "update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
		sessionFactoryBuilder.addProperties(hibernateProp);

		sessionFactoryBuilder.addAnnotatedClass(Blog.class);
		sessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
		sessionFactoryBuilder.addAnnotatedClass(Forum.class);
		sessionFactoryBuilder.addAnnotatedClass(ForumComment.class);
		sessionFactoryBuilder.addAnnotatedClass(FriendDetail.class);
		sessionFactoryBuilder.addAnnotatedClass(JobDetail.class);
		sessionFactoryBuilder.addAnnotatedClass(UserDetail.class);

		SessionFactory sessionFactory = sessionFactoryBuilder.buildSessionFactory();
		System.out.println("---------- SessionFactory Object ----------");
		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) 
	{
		System.out.println("---------- Hibernate Object ----------");
		return new HibernateTransactionManager(sessionFactory);
	}
}
