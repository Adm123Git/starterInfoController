package ru.adm123.starterInfo.provider;

import ru.adm123.starterInfo.model.EnvironmentInfo;

/**
 * Класс, предоставляющий информацию о среде выполнения
 */
public interface EnvironmentProvider {

    /**
     * Отдает информацию о среде выполнения
     *
     * @return {@link EnvironmentInfo}
     */
    EnvironmentInfo getEnvironmentInfo();

}
