package com.bbs.service.invitation;

import java.util.List;

import com.bbs.entity.bbs_invitation;

public interface invitationService {

	List<bbs_invitation> showAll();

	boolean add(bbs_invitation invi);

	boolean deletByid(String invitationId);

}
