package com.bbs.dao.plant;

import java.util.List;

import com.bbs.entity.bbs_category;
import com.bbs.entity.bbs_plate;

public interface plantDao {
	int savaplant (bbs_plate plant);

	List<bbs_plate> showAll();

	List<bbs_plate> findeByid(String plateId);

	int updata(bbs_plate plant);

	int deletById(int plateId);

	List<bbs_plate> scach(String plateTitle);

	int deletAll(String[] pids);

	List<bbs_category> showCall();
}
