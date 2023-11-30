package com.portpolio.mapper.ocoMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.portpolio.domain.dto.ocoDto.FileDTO;



@Mapper
public interface FileMapper {
	int insertFile(FileDTO file);
	List<FileDTO> getFiles(Long boardNum);	
	int deleteBySystemname(String systemName);
	int deleteByBoardnum(Long boardNum);
}
