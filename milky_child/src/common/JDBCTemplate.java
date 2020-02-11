package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Singletone Pattern
 * 클래스에 대한 객체가 프로그램 구동내내 딱 한개만 생성되어서 처리되도록 함.
 * 	- static 자원을 활용한 방법
 * 
 * Connectio 객체 생성
 * 트랜잭션 처리: commit, rollback
 * 자원 반납: Connecton, Statement, ResultSet
 *
 */

public class JDBCTemplate {
	
	public static Connection getConnection() {
		Connection conn = null;
		//현재 클래스 객체의 루트 디렉토리(build path - /WebContent/WEB-INF/classes)부터 위치한 파일의 경로를 찾는다.
		String fileName = JDBCTemplate.class.getResource("/driver.properties")
											.getPath();
//		System.out.println("fileName@JDBCTemplate=" + fileName);
		
		//1. Connection 생성
		try {
			Properties prop = new Properties();
			prop.load(new FileReader(fileName));
			
			//Property 내역 출력
//			prop.list(System.out);
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return conn;
	}
	
	public static void commit(Connection conn){
		try {
			if(conn != null && !conn.isClosed())
				conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn){
		try {
			if(conn != null && !conn.isClosed())
				conn.rollback();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed())
				rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
