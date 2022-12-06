package com.wz.cwolf.controller;

import com.wz.cwolf.common.result.Result;
import com.wz.cwolf.service.MinioFileUtilService;
import com.wz.cwolf.vo.FileResourceDeleteInVo;
import com.wz.cwolf.vo.UploadFileInVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 上传文件信息 前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-41-05
 */

@RestController
@RequestMapping("/fileResource")
@Api(tags = "文件管理")
public class FileResourceController {

    @Autowired
    private MinioFileUtilService minioFileUtilService;

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    @ApiImplicitParam(name = "files", value = "多个文件" , paramType = "formData",allowMultiple=true,required = true,dataType = "file")
    public Result<?> upload(@RequestParam("files") MultipartFile[] files, @Validated UploadFileInVo uploadFileInVo) {
        minioFileUtilService.upload(files, uploadFileInVo.getBucketName(), uploadFileInVo.getRelationId(),uploadFileInVo.getRelationCode());
        return Result.ok();
    }

    @ApiOperation("文件下载")
    @GetMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam("id") String id) {
        return minioFileUtilService.download(id);
    }

    @ApiOperation("文件删除")
    @DeleteMapping("/delete")
    public Result<?> delete(@Validated FileResourceDeleteInVo fileResourceDeleteInVo) {
        minioFileUtilService.delete(fileResourceDeleteInVo);
        return Result.ok();
    }
    //todo 静态资源文件管理系统：上传，获取文件链接，看场景如果是前端的公共资源，放在pulibc，如果是做身份校验的资源则从系统获取，
}
