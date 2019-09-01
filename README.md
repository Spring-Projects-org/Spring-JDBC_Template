# Spring-JDBC_Template
 Spring-JDBC_Template Example
 
 We can use org.springframework.jdbc.core.JdbcTemplate class to avoid boiler plate code. Spring JdbcTemplate is the central class in Spring JDBC core package and provides a lot of methods to execute queries and automatically parse ResultSet to get the Object or list of Objects.

All we need is to provide the arguments as Object array and implement Callback interfaces such as PreparedStatementSetter and RowMapper for mapping arguments or converting ResultSet data to bean objects. 
