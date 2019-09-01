package com.java.spring.jdbc.constant;

import java.io.IOException;

import com.java.spring.jdbc.config.LoadConfig;

public class JDBCConstant {
	
	
	
	public static final String EmployeeTable="Employee";
	public static final String JDBCDriver="com.mysql.jdbc.Driver";
	public static final String JDBCURL="jdbc:mysql://localhost:3306/testdb";
	public static String DBUSER;
	public static String DBPASS;
	
	static LoadConfig loadConfig=null;
	
	static
	{
		initJDBCConstant();	
	}
	
		
			private static void initJDBCConstant() {
				try {
					loadConfig=new LoadConfig();
					DBUSER=getUser();
					DBPASS=getPassword();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
			public static String getUser() throws IOException
			{
		       return loadConfig.getProperties().getProperty("user.name");
		       
			}
			
			public static String getPassword() throws IOException
			{
		       
		       return loadConfig.getProperties().getProperty("user.password");
		       
		       
			}
	

}
