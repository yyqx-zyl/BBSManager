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
import com.bbs.entity.bbs_invitation_ans;

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
	//删除
	@Override
	public int deleteByid(String invitationId) {
		String sql="DELETE  FROM bbs_invitation WHERE invitationId=?;";
		Object[] params= {invitationId};
		int num=execteUpdate(sql, params);
		System.out.println(num);
		return num;
	}
	//根据id查找
	@Override
	public bbs_invitation fundByid(String id) {
		bbs_invitation ii =null;
		//,p.plateTitle,c.category
		try {
			String sql="SELECT invitationMessage,plateId,categoryId  FROM bbs_invitation "
					+ " WHERE invitationId=?";
			Object[] params= {id};
			rs=querAll(sql, params);
			if(rs.next()) {
				  ii = new bbs_invitation(id,rs.getString("invitationMessage"),rs.getInt("plateId"), rs.getInt("categoryId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rs, pst, conn);
		}
		return ii;
	}
	//修改
	@Override
	public int update(bbs_invitation invi) {
		String sql="UPDATE bbs_invitation SET  invitationMessage=?, plateId=?,categoryId=? WHERE invitationId=?;";
		Object[] params= {invi.getInvitationMessage(),invi.getPlateId(),invi.getCategoryId(),invi.getInvitationId()};
		System.out.println("invi.getInvitationId()"+invi.getInvitationId());
		int num=execteUpdate(sql, params);
		System.out.println(num);
		return num;
	}
	//回帖信息
	@Override
	public List<bbs_invitation_ans> findeByid(String id) {
		List<bbs_invitation_ans> list=new ArrayList<bbs_invitation_ans>();
		try {
			String sql="SELECT * FROM bbs_invitation_ans where invitationId=?;";
			Object[] pararms= {id};
			rs=querAll(sql, pararms);
			while (rs.next()) {
				bbs_invitation_ans ans=new bbs_invitation_ans
						(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
				list.add(ans);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, null, null);
		}
		return list;
	}
	//回帖添加
	@Override
	public int addAns(bbs_invitation_ans ans) {
		String sql = "INSERT INTO bbs_invitation_ans(ansId,ansMessage,invitationId,userId) VALUES(?,?,?,?)";
		Object[] params = {ans.getAnsId(),ans.getAnsMessage(),ans.getInvitationId(),ans.getUserId()};
		return  execteUpdate(sql, params);
	}
	
}
