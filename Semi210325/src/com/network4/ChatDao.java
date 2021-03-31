package com.network4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;

public class ChatDao {
	Connection				con		= null;
	CallableStatement		cstmt	= null;
	DBConnectionMgr2		dbMgr	= new DBConnectionMgr2();
	OracleCallableStatement	ocstmt	= null;
	ResultSet				rs		= null;

	public ChatDao() {
		// TODO Auto-generated constructor stub
	}

	public String login(String id, String password) {
		String nickname = null;

		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_login(?,?,?)}");
			// 오라클 서버와 연결 통로가 확보 되었고 두 개의 ?자리 중 첫번째가 read속성이므로
			// p_empno를 첫번째 ?자리에 설정해야 함.
			cstmt.setString(1, id);
			cstmt.setString(2, password);
			cstmt.registerOutParameter(3, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			ResultSet cursor = ocstmt.getCursor(3);

			while (cursor.next()) {
				nickname = cursor.getString("nickname");
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage() + ", " + e.toString());// 힌트를 얻을 수 있다.
		}
		return nickname;
	}
}
