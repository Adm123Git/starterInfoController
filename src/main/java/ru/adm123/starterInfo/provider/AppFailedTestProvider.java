package ru.adm123.starterInfo.provider;

import java.util.List;

/**
 * Класс, предоставляющий данные о проваленных тестах
 */
public interface AppFailedTestProvider {

    /**
     * Отдает список имен проваленных тестов
     *
     * @return список проваленных тестов
     */
    List<String> getFailedTest();

}
