package com.portpolio.service.ocoService;

import java.util.List;

import com.portpolio.domain.dto.ocoDto.PlannerDTO;

public interface PlannerService {

	boolean plannerwrite(PlannerDTO planner);

	// delete
	public boolean remove(String loginUser, Long scheduleNum);

	List<PlannerDTO> getplannerList();

	PlannerDTO getDetail(Long scheduleNum);

	
}
