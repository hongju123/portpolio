package com.portpolio.controller.whatController;

import java.io.ObjectInputFilter.Status;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portpolio.domain.dto.whatDto.UserDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/what/user/*")
public class WhatUserController {

    @PostMapping("login")
    public ResponseEntity<Boolean> login(HttpServletRequest req,@RequestBody UserDTO user){
        req.getSession().setAttribute("user", user);
        return ResponseEntity.ok(true);
    }

}
