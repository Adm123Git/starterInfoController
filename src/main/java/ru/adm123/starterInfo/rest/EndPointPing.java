package ru.adm123.starterInfo.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "info-controller.end-point",
        name = "ping",
        havingValue = "true")
@Tag(name = "Пинг",
        description = "Пинг приложения")
public class EndPointPing {

    @GetMapping("ping")
    @Operation(operationId = "ping-getPing",
            summary = "Пингует приложение")
    @ApiResponse(responseCode = "200",
            description = "Без тела ответа")
    public void getPing() {
    }

}
