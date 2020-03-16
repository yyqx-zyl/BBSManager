package com.bbs.service.plant.impl;

import java.util.List;

import com.bbs.commons.DataUtils;
import com.bbs.dao.plant.plantDao;
import com.bbs.dao.plant.impl.plantDaoImpl;
import com.bbs.entity.bbs_plate;
import com.bbs.service.plant.plantService;

public class plantServiceImpl extends DataUtils implements plantService {
	//创建访问对象
	plantDao dao=new plantDaoImpl();
	//添加
	@Override
	public boolean savePlant(bbs_plate plant) {
		int rs=dao.savaplant(plant);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
	}
	//显示所有
	@Override
	public List<bbs_plate> showAll() {
		List<bbs_plate> plant=dao.showAll();
		if (plant!=null) {
			return plant;
		}else {
			return null;
		}
		
	}
	//根据id查询
	@Override
	public List<bbs_plate> findeByid(String plateId) {
		List<bbs_plate> plant=dao.findeByid(plateId);
		if (plant!=null) {
			return plant;
		}else {
			return null;
		}
	}
	//修改
	@Override
	public boolean updata(bbs_plate plant) {
		int rs=dao.updata(plant);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
	}
	//删除
	@Override
	public boolean deletById(int plateId) {
		int rs=dao.deletById(plateId);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
	}
	//搜索
	@Override
	public List<bbs_plate> scach(String plateTitle) {
		List<bbs_plate> plant=dao.scach(plateTitle);
		if (plant!=null) {
			return plant;
		}else {
			return null;
		}
	}
}
