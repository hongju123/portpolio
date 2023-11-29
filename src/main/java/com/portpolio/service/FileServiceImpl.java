package com.portpolio.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.portpolio.domain.dto.FileDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Value("D:\\workSpace\\home-work\\portpolio\\server-file\\")
    private String filePath;

    @Override
    public ResponseEntity<Resource> downLoadFile(FileDTO fileDTO,String location) throws IOException{
    	
    	System.out.println(filePath+fileDTO.getOriginalName()+",,,,,,,"+location);
        File file = new File(filePath+fileDTO.getOriginalName());
        log.info("{}",filePath+"/"+fileDTO.getOriginalName());
        System.out.println(file.exists());

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileDTO.getOriginalName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
    }

    @Override
    public boolean upLoadFile(FileDTO fileDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'upLoadFile'");
    }

    @Override
    public boolean deleteFile(FileDTO fileDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFile'");
    }

    @Override
    public boolean modifyFile(FileDTO fileDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifyFile'");
    }

    @Override
    public String showFile(FileDTO fileDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showFile'");
    }

}
