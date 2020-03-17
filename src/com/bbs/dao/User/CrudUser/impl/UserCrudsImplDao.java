package com.bbs.dao.User.CrudUser.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbs.commons.DataUtils;
import com.bbs.dao.User.CrudUser.UserCrudsDao;
import com.bbs.entity.bbs_user;

public class UserCrudsImplDao extends DataUtils implements UserCrudsDao {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	//验证登录的方法
			/**
			 * 
			 * @param UserId 用户名
			 * @param UserPsw 密码
			 * @return 用户名和密码相同的个数
			 */
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
	//增加
	@Override
	public int add(bbs_user user) {
		//sql语句
		String sql = "INSERT INTO bbs_user(userId,userpsw,userEmail,userSex,userPhoto,userScore,userLevel,userCreateDate) "
				+ "VALUES(?,?,?,?,?,default,default,default)";
		Object[] params = {user.getUserId(),user.getUserPsw(),user.getUserEmail(),user.getUserSex(),user.getUserPhoto()};
		//System.out.println(user.getUserPhoto());
		return execteUpdate(sql, params);
	}
	
	//显示用户数据
	@Override
	public List<bbs_user> show() {
		List<bbs_user> list=new ArrayList<bbs_user>();
		String sql="SELECT userId,userPsw,userSex,userEmail,userCreateDate  FROM bbs_user;";
		Object[] params= {};
		rs=querAll(sql, params);
		try {
			while (rs.next()) {
				list.add(new bbs_user(rs.getString("userId"),rs.getString("userPsw"),rs.getString("userSex"),
						rs.getString("userEmail"),rs.getDate("userCreateDate")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//删除
	@Override
	public int delete(String userId) {
		//sql语句
				String sql = "DELETE  FROM bbs_user WHERE userId=?";
				Object[] params = {userId};
				return execteUpdate(sql, params);
	}
	
	//根据id查询
	@Override
	public List<bbs_user> show(String userId) {
		List<bbs_user> list=new ArrayList<bbs_user>();
		String sql="SELECT userId,userSex,userEmail FROM bbs_user WHERE userId=?;";
		Object[] params= {userId};
		rs=querAll(sql, params);
		try {
			if (rs.next()) {
				list.add(new bbs_user(rs.getString("userId"),rs.getString("userSex"),
						rs.getString("userEmail")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//修改
	@Override
	public int cha(bbs_user user) {
		String sql="UPDATE bbs_user SET userPsw=? ,userEmail=?, userSex=? WHERE userId=?;";
		Object[] params= {user.getUserPsw(),user.getUserEmail(),user.getUserSex(),user.getUserId()};
		return execteUpdate(sql, params);
	}
	//批量删除
	@Override
	public int deleAll(String[] uids) {
		StringBuffer sql = new StringBuffer("delete from bbs_user where userId in(");
		// 根据参数数组的长度，拼接锁需要的?号个数
		for (int i = 0; i < uids.length; i++) {
			sql.append("?");
			if (i != uids.length-1) {
				sql.append(",");
			}
		}
		sql.append(")");
		// delete from bbs_user where userid in(test001,test002)
		return execteUpdate(sql.toString(), uids);
	}
	
	

}
