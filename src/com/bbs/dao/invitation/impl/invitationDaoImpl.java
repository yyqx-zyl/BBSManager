package com.bbs.dao.invitation.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.bbs.commons.DataUtils;
import com.bbs.dao.invitation.invitationDao;
import com.bbs.entity.bbs_invitation;

public class invitationDaoImpl extends DataUtils implements invitationDao {

	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	
	//显示所有
	@Override
	public List<bbs_invitation> showAll() {
		List<bbs_invitation> invi =new ArrayList<bbs_invitation>();
		//,p.plateTitle,c.category
		try {
			String sql="SELECT i.invitationId,i.invitationMessage,i.userId,p.plateTitle,c.category,i.isPass,"
					+ "i.isEnable,i.isCream,i.invitationCreate,i.invitationModify"
					+ " FROM bbs_invitation i "
					+ "INNER JOIN bbs_plate p ON(i.`plateId`=p.`plateId`) "
					+ "INNER JOIN bbs_category c ON(i.`categoryId`=c.`categoryId`);";
			rs=querAll(sql, null);
			while (rs.next()) {
				  invi.add(new bbs_invitation(rs.getString("i.invitationId"),rs.getString("i.invitationMessage"),
						  rs.getString("i.userId"), rs.getString("p.plateTitle"),rs.getString("c.category") , 
						  rs.getInt("i.isPass"),rs.getInt("i.isEnable"), rs.getInt("i.isCream"),rs.getDate("i.invitationCreate"),rs.getDate("i.invitationModify")));
				  System.out.println("name:"+rs.getString("i.userId"));
				  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return invi;
	}
	
	//添加
	@Override
	public int add(bbs_invitation invi) {
		String sql="INSERT INTO bbs_invitation(invitationId,invitationMessage,userId,plateId,"
				+ "categoryId,isPass,isEnable,isCream)"
				+ "VALUES(?,?,?,?,?,default,default,default);";
		Object[] params= {invi.getInvitationId(),invi.getInvitationMessage(),invi.getUserId(),invi.getPlateId(),
					invi.getCategoryId()};
		int num=execteUpdate(sql, params);
		System.out.println(num);
		return num;
	}

}
