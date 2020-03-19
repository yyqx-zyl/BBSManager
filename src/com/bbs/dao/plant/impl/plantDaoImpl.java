package com.bbs.dao.plant.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbs.commons.DataUtils;
import com.bbs.dao.plant.plantDao;
import com.bbs.entity.bbs_category;
import com.bbs.entity.bbs_plate;

public class plantDaoImpl extends DataUtils implements plantDao {

	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	//��Ӱ����Ϣ
	@Override
	public int savaplant(bbs_plate plant) {
		String sql="INSERT INTO bbs_plate(plateTitle,plateMessage,isEnable)VALUES(?,?,0);";
		Object[] params= {plant.getPlateTitle(),plant.getPlateMessage()};
		return execteUpdate(sql, params);
	}
	//��ʾ��Ϣ
	@Override
	public List<bbs_plate> showAll() {
		List<bbs_plate> plant=new ArrayList<bbs_plate>();
		
		try {
			String sql ="SELECT plateId,plateTitle,plateMessage,isEnable FROM bbs_plate ;";
			rs=querAll(sql, null);
			while (rs.next()) {
				plant.add(new bbs_plate(rs.getInt("plateId"),rs.getString("plateTitle"),
						rs.getString("plateMessage"),rs.getShort("isEnable")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plant;
	}
	//����id��ѯ
	@Override
	public List<bbs_plate> findeByid(String plateId) {
		List<bbs_plate> plant=new ArrayList<bbs_plate>();
		try {
			String sql ="SELECT plateId,plateTitle,plateMessage,isEnable FROM bbs_plate where plateId=?;";
			Object[] params= {plateId};
			rs=querAll(sql, params);
			if(rs.next()) {
				plant.add(new bbs_plate(rs.getInt("plateId"),rs.getString("plateTitle"),
						rs.getString("plateMessage"),rs.getShort("isEnable")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plant;
	}
	//�޸�
	@Override
	public int updata(bbs_plate plant) {
		String sql="UPDATE bbs_plate SET  plateTitle=?, plateMessage=?,isEnable=? WHERE plateId=?;";
		Object[] params= {plant.getPlateTitle(),plant.getPlateMessage(),plant.getIsEnable(),plant.getPlateId()};
		return execteUpdate(sql, params);
	}
	//ɾ��
	@Override
	public int deletById(int plateId) {
		String sql="DELETE  FROM bbs_plate WHERE plateId=?";
		Object[] params= {plateId};
		int num=execteUpdate(sql, params);
		return num;
	}
	//����
	@Override
	public List<bbs_plate> scach(String plateTitle) {
		List<bbs_plate> plant=new ArrayList<bbs_plate>();
		try {
			String sql ="SELECT plateId,plateTitle,plateMessage,isEnable FROM bbs_plate where plateTitle like CONCAT(?,'%');";
			Object[] params= {plateTitle};
			rs=querAll(sql, params);
			while(rs.next()) {
				plant.add(new bbs_plate(rs.getInt("plateId"),rs.getString("plateTitle"),
						rs.getString("plateMessage"),rs.getShort("isEnable")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plant;
	}
	//����ɾ��
	@Override
	public int deletAll(String[] pids) {
		StringBuffer sql = new StringBuffer("DELETE  FROM bbs_plate WHERE plateId in(");
		// ���ݲ�������ĳ��ȣ�ƴ������Ҫ��?�Ÿ���
		for (int i = 0; i < pids.length; i++) {
			sql.append("?");
			if (i != pids.length-1) {
				sql.append(",");
			}
		}
		sql.append(")");
		return execteUpdate(sql.toString(), pids);
		
	}
	//��ʾ���������
	@Override
	public List<bbs_category> showCall() {
		List<bbs_category> clant=new ArrayList<bbs_category>();
		
		try {
			String sql ="SELECT categoryId,category FROM bbs_category ;";
			rs=querAll(sql, null);
			while (rs.next()) {
				clant.add(new bbs_category(rs.getInt("categoryId"),rs.getString("category")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clant;
	}
}
