package com.portpolio.mapper.ocoMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.portpolio.domain.dto.ocoDto.Criteria;
import com.portpolio.domain.dto.ocoDto.ReplyDTO;


@Mapper
public interface ReplyMapper {
int insertReply(ReplyDTO reply);
	
	int updateReply(ReplyDTO reply);
	
	int deleteReply(Long replyNum);
	int deleteByBoardnum(Long boardNum);
	
	Long getLastNum(String userId);
	int getTotal(Long boardNum);
	List<ReplyDTO> getList(Criteria cri, Long boardNum);
	int getRecentReply(Long boardNum);
}
