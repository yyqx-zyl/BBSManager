package com.bbs.service.invitation;

import java.util.List;
import java.util.Map;

import com.bbs.entity.bbs_invitation;
import com.bbs.entity.bbs_invitation_ans;

public interface invitationService {

	List<bbs_invitation> showAll();

	boolean add(bbs_invitation invi);

	boolean deletByid(String invitationId);

	bbs_invitation fundByid(String id);

	boolean update(bbs_invitation invi);

	Map<String, Object> invian(String id);

	boolean addAns(bbs_invitation_ans ans);

}
