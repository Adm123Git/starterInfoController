package ru.adm123.starterInfo.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("f130admin")
public class F130Properties {

    private String hosturl;

}
