package java4s;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConstants {
	
	public Connection getBemspdConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ldap://ldap-ldprd.cisco.com:5000/cn=OracleContext,dc=cisco,dc=com/BEMSPRD","XXAPPSRO","Cyep5i6_R");
		return con; 
	}
	
	public Connection getepicprodConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ldap://ldap-ldprd.cisco.com:5000/cn=OracleContext,dc=cisco,dc=com/EPICPROD","XXTMT","C$Tep!c09");
		return con; 
	}
	
	

}
