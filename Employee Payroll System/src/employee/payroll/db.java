package employee.payroll;
import java.sql.*;
import javax.swing.*;

public class db {
	
	Connection conn=null;
	public static Connection java_db() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:E:\\JAVA Projects\\Employee Payroll System\\mydatabase.sqlite");
			return conn;
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}

}
