package com.portpolio.service.ocoService;

import com.portpolio.domain.dto.ocoDto.Criteria;
import com.portpolio.domain.dto.ocoDto.ReplyDTO;
import com.portpolio.domain.dto.ocoDto.ReplyPageDTO;

public interface ReplyService {
	boolean regist(ReplyDTO reply);
	
	boolean modify(ReplyDTO reply);
	
	boolean remove(Long replynum);
	
	ReplyPageDTO getList(Criteria cri, Long boardnum);
	
	Long getLastNum(String userid);
}
