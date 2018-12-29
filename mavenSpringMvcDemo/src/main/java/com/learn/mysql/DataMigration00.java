package com.learn.mysql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DataMigration00 {
	
	public static void main(String[] args) {

		DataMigration00.getAll();
//		DataMigration.insert(new Student("Achilles", "Male", "14"));
//		DataMigration.getAll();
//		DataMigration.update(new Student("Bean", "", "7"));
//		DataMigration.delete("Achilles");
//		DataMigration.getAll();
		
	}
	
	private static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://172.16.21.217:3307/cac_sso?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";
	    String username = "pc";
	    String password = "1w2q3u";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}	
	

	private static int insert(CacSystem cacSystem) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "insert into cac_system (Name,Sex,Age) values(?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, cacSystem.getName());
	        pstmt.setString(2, cacSystem.getShortName());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	
	private static int update(CacSystem cacSystem) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update cac_system set name='" + cacSystem.getName() + "' where short_name='" + cacSystem.getShortName() + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	private static Integer getAll() {
	    Connection conn = getConn();
	    String sql = "select * from cac_system";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	            	CacSystem cs=new CacSystem();
	            	cs.setId(Long.valueOf(rs.getString(1)));
	            	cs.setShortName("");
	            	cs.setName("");
	            	cs.setUrl("");
	             }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	
	private static int delete(String name) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "delete from cac_system where Name='" + name + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	
	
}
