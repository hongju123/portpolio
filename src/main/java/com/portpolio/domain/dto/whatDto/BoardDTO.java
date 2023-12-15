package com.portpolio.domain.dto.whatDto;

import lombok.Data;

@Data
public class BoardDTO {
	private Long boardNum;
	private String boardTitle;
	private String boardContents;
	private String updateDate;
	private String regDate;
	private int readCount;
	private String userId;
	private int replyCount;
	private String category; /* 카테고리값 저장컬럼 */
	private String topic; /* 카테고리값 저장컬럼 */
}
