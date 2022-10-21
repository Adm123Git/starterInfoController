package ru.adm123.starterInfo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
@Schema(description = "Объект, описывающий контакт")
public class Contact {

    @Schema(description = "Имя (название)")
    private String name;
    @Schema(description = "Номер телефона")
    private String phone;
    @Schema(description = "Эл. почта")
    private String email;
    @Schema(description = "Ссылка на веб-ресурс")
    private String web;

}
