package com.portpolio.domain.dto;

import lombok.Data;

@Data
public class FileDTO {
    String originalName;
    String fileName;
    String fileLocation;
    String fileUpload;

//유저 클릭 카운트는 테스트 해보고.....

// String userClickCnt;
}
