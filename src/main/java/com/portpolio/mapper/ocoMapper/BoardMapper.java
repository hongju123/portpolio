package com.portpolio.mapper.ocoMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.portpolio.domain.dto.ocoDto.BoardDTO;

@Mapper
public interface BoardMapper {
	//insert
	int insertBoard(BoardDTO board);
	
	//update
	int updateBoard(BoardDTO board);
	int updateReadCount(Long boardNum);
	
	//delete
	int deleteBoard(Long boardNum);
	
	//select
	List<BoardDTO> getList(Long amount, Long startRow,String topic);
	List<BoardDTO> getAllList(Long amount, Long startRow);
	Long getTotal();

	Long getLastNum(String userId);
	BoardDTO findByNum(Long boardNum);
	
	

}
