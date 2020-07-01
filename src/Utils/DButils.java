package Utils;

import java.sql.*;

public class DButils {
    private String url = "jdbc:mysql://localhost:3306/Course?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=UTC";

    private String user = "root";

    private String password = "mylifeforaiur";

    private Connection conn = null;

    private PreparedStatement stmt = null;

    private ResultSet rs = null;

    /**
     *获取链接对象
     *  */

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 链接数据库
     * */

    private void getConnect() {
        try {
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("链接数据库成功！！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("链接数据库失败！！");
        }
    }

    /**
     *获取链接
     * */

    public int doUpdate(String Sqls,Object params[]){
        getConnect();
        int i = 0;
        try {
            handleSql(Sqls, params);

            i = stmt.executeUpdate();
            System.out.println("执行状态："+i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    /**
     * 查询SQL语句，获取结果集合
     * */

    public ResultSet doQuery(String sql,Object params[]){
        getConnect();
        try {
            handleSql(sql, params);
            rs = stmt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    /**
     * 获取JDBC状态对象
     * */

    public void handleSql(String sql, Object[] params) throws SQLException {
        stmt = conn.prepareStatement(sql);
        if(params != null && params.length != 0){
            for(int j = 0 ;j < params.length;j++){
                stmt.setObject(j+1,params[j]);
            }
        }
        System.out.println("执行的sql语句为："+stmt.toString());
    }

    /**
     * 释放所有资源
     * */

    public void getClose() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
