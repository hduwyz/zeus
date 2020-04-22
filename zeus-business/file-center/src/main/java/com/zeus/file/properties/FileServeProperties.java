package com.zeus.file.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "zeus.file-server")
public class FileServeProperties {

    /**
     * 为以下3个值，指定不同的自动化配置
     * fastdfs：本地部署的fastDFS
     */
    private String type;

    /**
     * fastDFS配置
     */
    FdfsProperties fdfs = new FdfsProperties();
}
