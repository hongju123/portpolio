package com.portpolio.mapper.ocoMapper;

import org.apache.ibatis.annotations.Mapper;

import com.portpolio.domain.dto.ocoDto.BusinessDTO;

@Mapper
public interface BusinessMapper {
	boolean insertParentUser(BusinessDTO businessDto);
	boolean insertUser(BusinessDTO businessDto);
	boolean insertinfo(BusinessDTO businessDto);
	BusinessDTO findById(String businessId);
}

