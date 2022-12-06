package com.wz.cwolf.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.cwolf.common.exception.BizException;
import com.wz.cwolf.common.result.ResultCode;
import com.wz.cwolf.entity.FileResource;
import com.wz.cwolf.mapper.FileResourceMapper;
import com.wz.cwolf.service.MinioFileUtilService;
import com.wz.cwolf.util.MinioUtil;
import com.wz.cwolf.vo.FileResourceDeleteInVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author WangZhe
 * @version 1.0
 * @className FileUtilServiceImpl
 * @description
 * @date 2022/12/2 13:49
 */

@Service
public class MinioFileUtilServiceImpl extends ServiceImpl<FileResourceMapper, FileResource>  implements MinioFileUtilService {
    @Autowired
    private MinioUtil minioUtil;

    @Autowired
    private FileResourceMapper fileResourceMapper;


    @Override
    public void upload(MultipartFile[] multipartFile, String bucketName, String relationId, String relationCode) {
        minioUtil.existBucket(bucketName);
        List<String> upload = minioUtil.upload(multipartFile, bucketName);
        List<FileResource> uploadFiles = upload.stream().map(fileName -> {
            FileResource fileResource = new FileResource();
            fileResource.setFileName(fileName);
            fileResource.setBucketName(bucketName);
            fileResource.setRelationId(relationId);
            fileResource.setRelationCode(relationCode);
            fileResource.setStatus("1");
            return fileResource;
        }).collect(Collectors.toList());
        this.saveBatch(uploadFiles);
    }

    @Override
    public ResponseEntity<byte[]> download(String id) {
        FileResource uploadFile = fileResourceMapper.selectById(id);
        if(ObjectUtils.isEmpty(uploadFile)) {
            throw new BizException(ResultCode.UPLOAD_FILE_NOT_EXIST);
        }
        return minioUtil.download(uploadFile.getFileName(), uploadFile.getBucketName());
    }

    @Override
    public void delete(FileResourceDeleteInVo fileResourceDeleteInVo) {
        if(fileResourceDeleteInVo.getDeleteFlag().equals("true")) {
            //物理删除
            List<FileResource> fileResources = fileResourceMapper.selectBatchIds(fileResourceDeleteInVo.getIds());


        } else {
            //逻辑删除
            List<FileResource> fileResourceList = fileResourceDeleteInVo.getIds().stream().map(id -> {
                FileResource fileResource = new FileResource();
                fileResource.setId(id);
                fileResource.setStatus("0");
                return fileResource;
            }).collect(Collectors.toList());
            this.updateBatchById(fileResourceList);
        }
    }
}
