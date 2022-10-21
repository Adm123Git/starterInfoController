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
import ru.adm123.starterInfo.model.dto.SelfTest;
import ru.adm123.starterInfo.model.dto.State;
import ru.adm123.starterInfo.service.AppInfoService;

@RestController
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "info-controller.end-point",
        name = "selftest",
        havingValue = "true")
@RequiredArgsConstructor
@Tag(name = "Самодиагностика",
        description = "Информация о результатах самодиагностики приложения")
public class EndPointSelfTest {

    private final AppInfoService appInfoService;

    @GetMapping("selftest")
    @Operation(operationId = "selftest-getSelfTest",
            summary = "Информация о результатах самодиагностики")
    @ApiResponse(responseCode = "200",
            description = "Получение объекта, содержащего информацию о результатах самодиагностики приложения",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = SelfTest.class)))
    public SelfTest etSelfTest() {
        return appInfoService.getSelfTest();
    }

}
