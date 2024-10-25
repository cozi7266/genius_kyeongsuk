package com.ssafy.myboard.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String url = "jdbc:mysql://localhost:3306/examdb?serverTimezone=UTC";
	private static final String username = "ssafy";
	private static final String password = "ssafy";
	private static final String driverName = "com.mysql.cj.jdbc.Driver";
	private static DBUtil instance = new DBUtil();

	static {
		// JDBC 드라이버를 로딩한다. 드라이버 로딩은 객체 생성 시 한번만 진행하도록 하자.
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DBUtil getInstance() {
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}