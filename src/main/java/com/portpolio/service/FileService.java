package com.portpolio.service;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

import org.springframework.core.io.Resource;
import com.portpolio.domain.dto.FileDTO;

import jakarta.servlet.http.HttpServletRequest;

public interface FileService {
    public ResponseEntity<Resource> downLoadFile(FileDTO fileDTO) throws IOException;
    public boolean upLoadFile(FileDTO fileDTO);
    public boolean deleteFile(FileDTO fileDTO);
    public boolean modifyFile(FileDTO fileDTO);

    public String showFile(FileDTO fileDTO);
}
