package com.network4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnectionMgr2 {
	Connection			con		= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;

	public Connection getConnection() {

		try {
			Class.forName(OracleAccount.CHAT_DRIVER);
			con = DriverManager.getConnection(OracleAccount.CHAT_URL, OracleAccount.CHAT_USER, OracleAccount.CHAT_PW);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public Connection getConnectionDataSource() {

		try {
			Context		initCtx	= new InitialContext();
			DataSource	ds		= (DataSource) initCtx.lookup("java:comp/env/ibbPool");
			con = ds.getConnection();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void freeConnection(ResultSet rs, PreparedStatement pstmt, Connection con) {

		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void freeConnection(PreparedStatement pstmt, Connection con) {

		try {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void freeConnection(ResultSet rs, CallableStatement cstmt, Connection con) {

		try {
			if (rs != null)
				rs.close();
			if (cstmt != null)
				cstmt.close();
			if (con != null)
				con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void freeConnection(CallableStatement cstmt, Connection con) {

		try {
			if (cstmt != null)
				cstmt.close();
			if (con != null)
				con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
