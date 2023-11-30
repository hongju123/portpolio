package com.portpolio.mapper.ocoMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.portpolio.domain.dto.ocoDto.PlannerDTO;

@Mapper
public interface PlannerMapper {
	
	int insertPlanner(PlannerDTO planner);

	List<PlannerDTO> getplannerList();

	PlannerDTO findByNum(Long scheduleNum);

	int deletereservation(Long scheduleNum);
	
	PlannerDTO findByUser(String userId);
	

}
