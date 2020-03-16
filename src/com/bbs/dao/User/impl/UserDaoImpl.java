package com.bbs.dao.User.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bbs.commons.DataUtils;
import com.bbs.dao.User.Userdao;

public class UserDaoImpl extends DataUtils implements Userdao {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	
	@Override
	public int verification(String UserId, String UserPsw) {
		String sql="SELECT COUNT(1) FROM  bbs_user WHERE userId=? AND userpsw=?";
		Object[] params= {UserId,UserPsw};
		
		ResultSet rs=querAll(sql, params);
		try {
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rs,null, null);
		}
		return 0;
	}

}
