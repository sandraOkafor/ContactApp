package com.app.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = "com.app")

public class HibernateCfg {

  @Autowired    //automatically initializes the e variable
  private Environment e;

  //@Bean
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    
    // Setting JDBC properties
    dataSource.setDriverClassName(e.getProperty("database.driver"));
    dataSource.setUrl(e.getProperty("database.url"));
    dataSource.setUsername(e.getProperty("database.user"));
    dataSource.setPassword(e.getProperty("database.password"));
    
    return dataSource;
  }

  @Bean
  public SessionFactory getSessionFactory() {
    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getDataSource());
    sessionBuilder.scanPackages("com.app.model");

    Properties prp = new Properties();
    // Setting Hibernate properties
    prp.put(SHOW_SQL, e.getProperty("hibernate.show_sql"));
    prp.put(HBM2DDL_AUTO, e.getProperty("hibernate.hbm2ddl.auto"));
    prp.put(DIALECT, e.getProperty("hibernate.dialect"));

    sessionBuilder.addProperties(prp);

    return sessionBuilder.buildSessionFactory();
  }

  @Autowired
  @Bean
  public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
    HibernateTransactionManager txManager = new HibernateTransactionManager(sessionFactory);
    return txManager;
  }    
}
