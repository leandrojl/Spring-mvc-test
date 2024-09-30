package com.tallerwebi.infraestructura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateInfraestructuraTestConfig {
    //uso mysql como base de datos, comentando las linea sde codigo qe hacen referencia a hsql
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:hsqldb:mem:db_");
        dataSource.setUrl("jdbc:mysql://localhost:3306/tw1");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
    //la sesion que maneja la base de datos
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("com.tallerwebi.dominio"); //aca busca las clases para convertirlas en entidades
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory(dataSource()).getObject());
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        // properties.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty("hibernate.show_sql", "true"); //muestra las sentencias que se ejecutan
        properties.setProperty("hibernate.format_sql", "true");
        // properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.hbm2ddl.auto", "update"); //nos recomienda usar update para qe no dropee la tabla
        return properties;
    }
}
