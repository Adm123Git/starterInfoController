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
import ru.adm123.starterInfo.model.dto.State;
import ru.adm123.starterInfo.service.AppInfoService;

@RestController
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "info-controller.end-point",
        name = "state",
        havingValue = "true")
@RequiredArgsConstructor
@Tag(name = "Состояние",
        description = "Информация о состоянии приложения")
public class EndPointState {

    private final AppInfoService appInfoService;

    @GetMapping("state")
    @Operation(operationId = "state-getState",
            summary = "Информация о текущем состоянии приложения")
    @ApiResponse(responseCode = "200",
            description = "Получение объекта, содержащего информацию о текущем состоянии приложения",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = State.class)))
    public State getState() {
        return appInfoService.getState();
    }

}
