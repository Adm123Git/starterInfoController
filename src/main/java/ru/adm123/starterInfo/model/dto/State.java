package ru.adm123.starterInfo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.adm123.starterInfo.model.Contact;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.OK;

@Setter
@Getter
@Accessors(chain = true)
@Schema(description = "Объект, содержащий информацию о состоянии приложения")
public class State {

    @Schema(description = "Имя сервиса")
    private String service;
    @Schema(description = "Тип сервиса")
    private String type;
    @Schema(description = "Название приложения")
    private String name;
    @Schema(description = "Название системы")
    private String system;
    @Schema(description = "Номер версии приложения в строковом представлении")
    private String version;
    @Schema(description = "Текущий профиль приложения")
    private String activeProf;
    @Schema(description = "Хост БД ElasticSearch")
    private String elasticHost;
    @Schema(description = "Хост сервиса F130Admin")
    private String f130AdminHost;
    @Schema(description = "Контакт разработчика")
    private Contact develop;
    @Schema(description = "Контакт поддержки")
    private Contact support;
    @Schema(description = "Текущее серверное время в строковом представлении")
    private final String now = LocalDateTime.now().toString();
    @Schema(description = "Статус приложения в числовом представлении (всегда 200)")
    private final int status = OK.value();

}
