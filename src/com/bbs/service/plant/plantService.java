package com.bbs.service.plant;

import java.util.List;

import com.bbs.entity.bbs_category;
import com.bbs.entity.bbs_plate;

public interface plantService {
	boolean savePlant(bbs_plate plant);

	List<bbs_plate> showAll();

	List<bbs_plate> findeByid(String plateId);

	boolean updata(bbs_plate plant);

	boolean deletById(int plateId);

	List<bbs_plate> scach(String plateTitle);

	boolean deletAll(String ids);

	List<bbs_category> showCall();
}
