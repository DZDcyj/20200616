package dao;

import Course.Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class CourseDao {
	public void add(Course course) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url= "jdbc:mysql://localhost:3306/course?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&useSSL=false&verifyServerCertificate=false&autoReconnct=true&autoReconnectForPools=true&allowMultiQueries=true&allowPublicKeyRetrieval=true";
		
		String user = "root";
		String password = "mylifeforaiur";
		
		Connection connection
			= DriverManager.getConnection(url, user, password);
		Statement statement =connection.createStatement();

		String insertSql = "insert into course ( Course_id, Course_name, Course_image_url, Course_video_url, Course_description) values ("+course.getCourse_id()+","+course.getCourse_name()+","+course.getImage_url()+","+course.getVideo_url()+","+course.getCourse_views()+");";
		statement.execute(insertSql);
		statement.close();
		connection.close();
	}
	
	public void delete(int courseId) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url= "jdbc:mysql://localhost:3306/wechat?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&useSSL=false&verifyServerCertificate=false&autoReconnct=true&autoReconnectForPools=true&allowMultiQueries=true&allowPublicKeyRetrieval=true";
		
		String user = "root";
		String password = "mylifeforaiur";
		
		Connection connection
			= DriverManager.getConnection(url, user, password);
		Statement statement =connection.createStatement();
		String sql = "delete from course where Course_id="+courseId;
		statement.execute(sql);
		statement.close();
		connection.close();
	}
	
	public boolean search(int courseId) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url= "jdbc:mysql://localhost:3306/course?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&useSSL=false&verifyServerCertificate=false&autoReconnct=true&autoReconnectForPools=true&allowMultiQueries=true&allowPublicKeyRetrieval=true";
		
		String user = "root";
		String password = "mylifeforaiur";
		
		Connection connection
			= DriverManager.getConnection(url, user, password);
		String sql = "select * from user where Course_id="+courseId;
		PreparedStatement pstmt=connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			rs.close();
			pstmt.close();
			connection.close();
			return true;
		}
		rs.close();
		pstmt.close();
		connection.close();
		return false;
	}
	
	
	
}
