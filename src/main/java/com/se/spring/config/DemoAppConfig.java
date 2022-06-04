package com.se.spring.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.se.spring")
@PropertySource({"classpath:db.properties"})
public class DemoAppConfig implements WebMvcConfigurer {
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource myDataSource() {
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();
		try {
			myDataSource.setDriverClass(env.getProperty("driver"));
		}catch(PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		myDataSource.setJdbcUrl(env.getProperty("url"));
		myDataSource.setUser(env.getProperty("user"));
		myDataSource.setPassword(env.getProperty("password"));
		
		myDataSource.setInitialPoolSize(getIntProperty("initialSize"));
		myDataSource.setMinPoolSize(getIntProperty("min"));
		myDataSource.setMaxPoolSize(getIntProperty("max"));
		myDataSource.setMaxIdleTime(getIntProperty("maxIdle"));
		


		
		return myDataSource;
			
	}

	private int getIntProperty(String string) {
		// TODO Auto-generated method stub
		String proVal = env.getProperty(string);
		int intProVal = Integer.parseInt(proVal);
		return intProVal;
	}
	
	private Properties getHibernateProperties() {
		Properties props = new Properties();
		props.setProperty("dialect", env.getProperty("dialect"));
		props.setProperty("show", env.getProperty("show"));
		return props;
		
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("packageToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManage = new HibernateTransactionManager();
		hibernateTransactionManage.setSessionFactory(sessionFactory);
		return hibernateTransactionManage;
	}
	public void addResourceHanders (ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}
	
	

}
