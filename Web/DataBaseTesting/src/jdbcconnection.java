import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcconnection {

	public static void main(String[] args) throws SQLException {

		// "jdbc"mysql://"+host+":"+port+"/databasename";

		// "jdbc"mysql://"+localhost+":"+3306+"/Employeeportal";

		String hostname = "localhost";
		String port = "3306";

		Connection con = DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + port + "/Employeeportal",
				"root", "root");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("Select * from Employeeinfo where dept = 'IT'");
		
		while(rs.next()) {
		System.out.println(rs.getString("name"));
		System.out.println(rs.getString("id"));
		}
	}

}
