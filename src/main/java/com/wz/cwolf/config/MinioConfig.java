package com.wz.cwolf.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangZhe
 * @version 1.0
 * @className MinioConfig
 * @description
 * @date 2022/12/2 15:18
 */

@Configuration
@ConfigurationProperties(prefix = "minio")
@Data
public class MinioConfig {

    private String accessKey;
    private String secretKey;
    private String endpoint;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }


}
