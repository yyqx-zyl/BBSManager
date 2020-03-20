package com.bbs.dao.invitation;

import java.util.List;


import com.bbs.entity.bbs_invitation;
import com.bbs.entity.bbs_invitation_ans;

public interface invitationDao {

	List<bbs_invitation> showAll();

	int add(bbs_invitation invi);

	int deleteByid(String invitationId);

	bbs_invitation fundByid(String id);

	int update(bbs_invitation invi);
	List<bbs_invitation_ans> findeByid(String id);

	int addAns(bbs_invitation_ans ans);
}
