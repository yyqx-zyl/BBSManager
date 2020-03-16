package com.bbs.commons;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataUtils {
	// ��дһ����̬��������������ݿ�����
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static Connection conn = null;

	// �������
	public static Connection createConnection() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bbsdb?useUnicode=true&characterEncoding=UTF-8", "root",
					"1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// �ͷ���Դ
	public static void closeAll(ResultSet rs, PreparedStatement pst, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//��ɾ�Ĳ�
	public static int execteUpdate(String sql,Object ... params) {
		Connection conn=createConnection();
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement(sql);
			if (params !=null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject((i+1),params[i]);
				}
			}
			return pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			closeAll(null, pst, conn);
		}
		return 0;
	}
	//��ѯ
	public static ResultSet querAll(String sql,Object ... params) {
		ResultSet rs=null;
		Connection conn=createConnection();
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement(sql);
			if (params !=null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject((i+1),params[i]);
				}
			}
			rs=pst.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	
}
