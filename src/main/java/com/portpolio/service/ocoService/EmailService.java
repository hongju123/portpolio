package com.portpolio.service.ocoService;

import com.portpolio.domain.dto.ocoDto.MailDTO;
import com.portpolio.domain.dto.ocoDto.UserDTO;

public interface EmailService {
	public void sendSimpleMessage(MailDTO mailDto);
	public String getEmailCode(MailDTO mailDto);
	public boolean checkcode(String code, String email);
	public boolean sendUserpassword(UserDTO user);
}
