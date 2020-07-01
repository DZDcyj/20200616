package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CommentDao {
	public void delete(int disId) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url= "jdbc:mysql://localhost:3306/course?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&useSSL=false&verifyServerCertificate=false&autoReconnct=true&autoReconnectForPools=true&allowMultiQueries=true&allowPublicKeyRetrieval=true";
		
		String user = "root";//mysql用户
		String password = "mylifeforaiur";//mysql用户密码
		
		Connection connection
			= DriverManager.getConnection(url, user, password);
		Statement statement =connection.createStatement();
		String insertSql = "delete from discussion where discussion_id="+ disId;
		statement.execute(insertSql);
		statement.close();
		connection.close();
	}
}
