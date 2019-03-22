package com.learn.mysqlbettertest;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.learn.mysqlbettertest.domain.Course;
import com.learn.mysqlbettertest.domain.Student;
import com.learn.mysqlbettertest.domain.StudentCourse;
import com.mysql.jdbc.Connection;

public class Test {

	public static void main(String args[]) throws SQLException {
//		InsertData.getAll();
//		insertStudentData();
//		insertCourseData();
		insertStudentCourseData();
//		InsertData.getAll();
//		InsertData.update(new Student("Bean"));
//		InsertData.delete("Achilles");
//		InsertData.getAll();
		
//		testRandom();
	}
	
	public static void testRandom(){
		
        //打印 30到50之间的随机数
        int min = 30;
        int max = 50;
        for(int i=0;i<10;i++){
            System.out.println(new Random().nextInt(max-min)+min);
            System.out.println(new Random().nextInt(max-min)+min);
            System.out.println(new Random().nextInt(max-min)+min);
            System.out.println("-------------");
        }
		
	}
	
	private static void insertStudentCourseData() throws SQLException {
		Connection conn = getConn();
		PreparedStatement pstmt=null;
		Long t1=System.currentTimeMillis();
		System.out.println("准备写入StudentCourse，time="+t1);
		for(int i=0;i<80;i++){
			for(int j=i*10000;j<(i+1)*10000;j++){
				Test.insertStudentCourse(conn,pstmt,new StudentCourse(new Random().nextInt(79743),new Random().nextInt(200),new Random().nextInt(130-50)+50));
			}
		}
		System.out.println("完成写入StudentCourse，耗时time="+String.valueOf(System.currentTimeMillis()-t1));
		pstmt.close();
		conn.close();
	}
	

	private static void insertStudentData() {
		Connection conn = getConn();
		Long t1=System.currentTimeMillis();
		System.out.println("准备写入Student，time="+t1);
		for(int i=63206;i<90000;i++){
			Test.insertStudent(conn,new Student("jack_"+i));
		}
		System.out.println("完成写入Student，time="+String.valueOf(System.currentTimeMillis()-t1));
	}
	
	private static void insertCourseData() {
		Connection conn = getConn();
		Long t1=System.currentTimeMillis();
		System.out.println("准备写入course，time="+t1);
		for(int i=0;i<200;i++){
			Test.insertCourse(conn,new Course("math_"+i));
		}
		System.out.println("完成写入course，time="+String.valueOf(System.currentTimeMillis()-t1));
	}

	private static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/student";
		String username = "root";
		String password = "root";
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	private static int insertStudent(Connection conn,Student student) {
		int i = 0;
		String sql = "insert into student (name) values(?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	private static int insertCourse(Connection conn,Course course) {
		int i = 0;
		String sql = "insert into course (name) values(?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, course.getName());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	private static int insertStudentCourse(Connection conn,PreparedStatement pstmt,StudentCourse studentCourse) {
		int i = 0;
		String sql = "insert into stu_course (s_id,c_id,score) values(?,?,?)";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, studentCourse.getSid());
			pstmt.setInt(2, studentCourse.getCid());
			pstmt.setInt(3, studentCourse.getScore());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}	
	

	private static int update(Student student) {
		Connection conn = getConn();
		int i = 0;
		String sql = "update students set name='" + student.getName()
				+ "' where id='" + student.getId() + "'";
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
		String sql = "select * from students";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			System.out.println("============================");
			while (rs.next()) {
				for (int i = 1; i <= col; i++) {
					System.out.print(rs.getString(i) + "\t");
					if ((i == 2) && (rs.getString(i).length() < 8)) {
						System.out.print("\t");
					}
				}
				System.out.println("");
			}
			System.out.println("============================");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static int delete(String name) {
		Connection conn = getConn();
		int i = 0;
		String sql = "delete from students where Name='" + name + "'";
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
