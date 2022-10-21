package ru.adm123.starterInfo.provider;

/**
 * Класс, предоставляющий данные о названиях
 */
public interface AppNameProvider {

    /**
     * Отдает имя приложения
     *
     * @return {@link String}
     */
    String getAppName();

    /**
     * Отдает название сервиса
     *
     * @return {@link String}
     */
    String getServiceName();

    /**
     * Отдает название типа сервиса
     *
     * @return {@link String}
     */
    String getServiceType();

}
