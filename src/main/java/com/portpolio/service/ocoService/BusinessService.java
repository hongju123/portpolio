package com.portpolio.service.ocoService;

import com.portpolio.domain.dto.ocoDto.BusinessDTO;

public interface BusinessService {
	public boolean insert(BusinessDTO businessDto);
	public boolean findById(String businessUsers);
	 
}
