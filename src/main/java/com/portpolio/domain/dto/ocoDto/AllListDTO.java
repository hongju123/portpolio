package com.portpolio.domain.dto.ocoDto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AllListDTO {
	List<BusinessDTO> ulist;
	List<BusinessInfoDTO> ilist;
	List<ProfileDTO> plist;
	List<FileDTO> flist;
}
