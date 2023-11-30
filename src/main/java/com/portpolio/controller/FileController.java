//package com.portpolio.controller;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.portpolio.domain.dto.FileDTO;
//import com.portpolio.service.FileService;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Controller
//@ResponseBody
//@RequestMapping("/api/file")
//public class FileController {
//    @Autowired
//    FileService fileService;
//
//    @GetMapping(value = { "/{option}/{filename}" })
//    public ResponseEntity<Resource> fileOption(@PathVariable String option, @PathVariable String filename)
//            throws IOException {
//        FileDTO file = new FileDTO();
//        file.setOriginalName(filename);
//        log.info("{}{}", option, filename);
//        switch (option) {
//            case "downLoad":
//                return fileService.downLoadFile(file);
//            case "upLoad":
//                return ResponseEntity.status(HttpStatus.CREATED).build();
//            default:
//                log.info("invaild option");
//                return ResponseEntity.status(HttpStatus.CREATED).build();
//        }
//    }
//}
