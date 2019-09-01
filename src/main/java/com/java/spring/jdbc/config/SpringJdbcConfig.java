package com.java.spring.jdbc.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.java.spring.jdbc.constant.JDBCConstant;


@Configuration
@PropertySource("application.properties")
@ComponentScan("com.java.spring.jdbc")

public class SpringJdbcConfig {
	
	

	@Bean
    public DataSource mysqlDataSource() throws IOException {
    	
        //LoadConfig config =new LoadConfig();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(JDBCConstant.JDBCDriver);
        dataSource.setUrl(JDBCConstant.JDBCURL);
        
       // System.out.println("User:"+JDBCConstant.DBUSER);
        dataSource.setUsername(JDBCConstant.DBUSER);
        dataSource.setPassword(JDBCConstant.DBPASS);
 
        return dataSource;
    }
}
