package ru.adm123.starterInfo.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("elasticsearch")
public class ElasticProperties {

    private String schema;
    private String hostname;
    private int port;

}
