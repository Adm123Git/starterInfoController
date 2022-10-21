package ru.adm123.starterInfo.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.adm123.starterInfo.model.dto.Version;
import ru.adm123.starterInfo.service.AppInfoService;

@RestController
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "info-controller.end-point",
        name = "version",
        havingValue = "true")
@RequiredArgsConstructor
@Tag(name = "Версия",
        description = "Информация о версии")
public class EndPointVersion {

    private final AppInfoService appInfoService;

    @GetMapping("version")
    @Operation(operationId = "version-getVersion",
            summary = "Информация о версии приложения")
    @ApiResponse(responseCode = "200",
            description = "Получение объекта, содержащего информацию о версии приложения",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Version.class)))
    public Version getVersion() {
        return appInfoService.getVersion();
    }

}
