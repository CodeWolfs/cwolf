package com.wz.cwolf.entity;

import lombok.Data;

/**
 * @author WangZhe
 * @version 1.0
 * @className MinioObject
 * @description minio 对象实体
 * @date 2022/12/2 15:27
 */

@Data
public class MinioObject {
    private String objectName;
    private Long size;
}
