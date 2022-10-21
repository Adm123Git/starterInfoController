package ru.adm123.starterInfo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Schema(description = "Объект, содержащий информацию о версии приложения")
public class Version {

    @Schema(description = "Номер версии приложения в строковом представлении",
            example = "1.2.3.4")
    private final String version;

}
