package com.wz.cwolf.service;

import com.wz.cwolf.vo.FileResourceDeleteInVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface MinioFileUtilService {

    void upload(MultipartFile[] multipartFile, String bucketName, String relationId, String relationCode);

    ResponseEntity<byte[]> download(String id);

    void delete(FileResourceDeleteInVo fileResourceDeleteInVo);
}
