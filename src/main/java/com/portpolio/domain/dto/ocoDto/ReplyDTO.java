package com.portpolio.domain.dto.ocoDto;

import lombok.Data;

@Data
public class ReplyDTO {
	private Long replyNum;
	private String replyContents;
	private String regDate;
	private double grade;
	private String updateDate;
	private String userId;
	private Long boardNum;
}
