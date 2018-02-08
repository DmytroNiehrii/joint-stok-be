package com.jointstock.jointstokbe.model;

import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "userEntityManagerFactory",
        transactionManagerRef = "userTransactionManager")
public class Config {
    @Bean
    PlatformTransactionManager userTransactionManager() {
        return new JpaTransactionManager(userEntityManagerFactory().getObject());
    }

    @Bean
    LocalContainerEntityManagerFactoryBean userEntityManagerFactory() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(userDataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan(Config.class.getPackage().getName());

        return factoryBean;
    }

    @Bean
    DataSource userDataSource() {

        return new EmbeddedDatabaseBuilder().//
                setType(EmbeddedDatabaseType.HSQL).//
                setName("user").//
                build();
    }
}