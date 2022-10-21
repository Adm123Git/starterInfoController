package ru.adm123.starterInfo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@Accessors(chain = true)
@Schema(description = "Объект, содержащий информацию о результатах самодиагностики приложения")
public class SelfTest {

    @Schema(description = "Список проваленных тестов")
    private List<String> failedTests;
    @Schema(description = "Номер версии приложения в строковом представлении")
    private String version;
    @Schema(description = "Текущий профиль приложения")
    private String activeProf;
    @Schema(description = "Хост БД ElasticSearch")
    private String elasticHost;
    @Schema(description = "Хост сервиса F130Admin")
    private String f130AdminHost;

}
