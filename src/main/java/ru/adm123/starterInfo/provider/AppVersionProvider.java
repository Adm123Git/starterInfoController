package ru.adm123.starterInfo.provider;

/**
 * Класс, предоставляющий данные о версии приложения
 */
public interface AppVersionProvider {

    /**
     * Отдает версию приложения
     *
     * @return {@link  String}
     */
    String getAppVersion();

}
