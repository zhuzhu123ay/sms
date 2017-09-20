package com.huihui.sms.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//连接对象工厂�?
public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String password;
	private static String user;
	
	static{
		driver="com.mysql.jdbc.Driver";
		url="jdbc:mysql://127.0.0.1:3306/sms?characterEncoding=UTF-8";
		password="root";
		user="root";
	}
	
	public static Connection getConn() throws Exception{
		//1.加载驱动
		Class.forName(driver);
		//2.获取连接
		Connection conn=DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	public static void close(ResultSet rs,PreparedStatement pstmt,
			Connection conn) throws SQLException{
		//释放资源
		if(pstmt!=null){
			pstmt.close();
		}
		if(conn!=null){
			conn.close();
		}
		if(rs!=null){
			rs.close();
		}
	}
}
