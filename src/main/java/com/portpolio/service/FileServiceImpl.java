package com.portpolio.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portpolio.domain.dto.FileDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Value("${file.path}")
    private String filePath;

    @Override
    public ResponseEntity<Resource> downLoadFile(FileDTO fileDTO) throws IOException {
            File file = new File(filePath + fileDTO.getOriginalName());
            log.info("{}", filePath + "/" + fileDTO.getOriginalName());

            if (file.exists()) {
                InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
                return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileDTO.getOriginalName())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
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
