package com.root.Story;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AppConfig {

	@Value("${spring.datasource.driver}")
	private String driverName;
	
	@Value("${spring.datasource.url}")
	private String dataSourceUrl;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driverName);
		basicDataSource.setUrl(dataSourceUrl);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		basicDataSource.setInitialSize(10);
		basicDataSource.setMaxActive(100);
		return basicDataSource;
	}

	@Bean
	public Properties hibernateProperties() {
		Properties hProperties = new Properties();
		boolean val = true;
		hProperties.put("hibernate.show_sql", val);
		hProperties.put("hibernate.format_sql", val);
		hProperties.put("hibernate.use_sql_comments", val);
		hProperties.put("hibernate.hbm2ddl.auto", "update");
		hProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		return hProperties;
	}

	@Bean
	public LocalSessionFactoryBean getLocalSessionFactory() {
		LocalSessionFactoryBean lBean = new LocalSessionFactoryBean();
		lBean.setPackagesToScan("com.root.Story");
		lBean.setDataSource(dataSource());
		lBean.setHibernateProperties(hibernateProperties());
		return lBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getLocalSessionFactory().getObject());
		return transactionManager;
	}

}

