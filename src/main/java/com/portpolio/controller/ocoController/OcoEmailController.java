package com.portpolio.controller.ocoController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portpolio.domain.dto.ocoDto.MailDTO;
import com.portpolio.service.ocoService.EmailService;


@Controller
@RequestMapping("/mail/*")
public class OcoEmailController {
    String brand = "OCO";
    private EmailService emailService;

    public OcoEmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("send")
    public String main() {
        return "ocoProject/hong/SendMail.html";
    }

    @PostMapping("send")
    public String sendMail(MailDTO mailDto) {
        emailService.sendSimpleMessage(mailDto);
        return "ocoProject/hong/SendMail.html";
    }

    @ResponseBody
    @PostMapping("getEmailcode")
    public String getCode(MailDTO mailDto) {
        return emailService.getEmailCode(mailDto);
    }

    @ResponseBody
    @PostMapping("checkcode")
    public boolean checkCode(String code, String email) {
        return emailService.checkcode(code, email);
    }
}