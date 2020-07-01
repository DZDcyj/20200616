package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class UserDao {
	public void banUser(String userName)throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url= "jdbc:mysql://localhost:3306/course?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&useSSL=false&verifyServerCertificate=false&autoReconnct=true&autoReconnectForPools=true&allowMultiQueries=true&allowPublicKeyRetrieval=true";
		
		String user = "root";
		String password = "mylifeforaiur";
		
		Connection connection
			= DriverManager.getConnection(url, user, password);
		Statement statement =connection.createStatement();
		String 	insertSql = "update user set user_isBan = '" + "1" + 
				"'where usrName = '" + userName+"'";

		statement.execute(insertSql);
		statement.close();
		connection.close();
	}
	
	public void addRecCourse(long usrId, long courseId)throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url= "jdbc:mysql://localhost:3306/course?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&useSSL=false&verifyServerCertificate=false&autoReconnct=true&autoReconnectForPools=true&allowMultiQueries=true&allowPublicKeyRetrieval=true";
		
		String user = "root";
		String password = "mylifeforaiur";
		
		Connection connection
			= DriverManager.getConnection(url, user, password);
		Statement statement =connection.createStatement();
		String sql = "select * from user where usrId="+usrId;
		PreparedStatement pstmt=connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			//从表rec_course，储存用户的推荐课程,字段usrId long,Course_id long.
			String insertSql = "insert into rec_course ( usrId, Course_id) values ("+usrId+","+courseId+");";
			statement.execute(insertSql);
			statement.close();
			connection.close();
		}
		
	}

}
