package com.bbs.dao.invitation;

import java.util.List;


import com.bbs.entity.bbs_invitation;

public interface invitationDao {

	List<bbs_invitation> showAll();

	int add(bbs_invitation invi);

	int deleteByid(String invitationId);

}
