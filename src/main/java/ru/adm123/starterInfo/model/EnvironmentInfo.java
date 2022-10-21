package ru.adm123.starterInfo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
@Schema(description = "Объект, содержащий информацию о среде выполнения приложения")
public class EnvironmentInfo {

    private String system;
    private String activeProfile;

}
