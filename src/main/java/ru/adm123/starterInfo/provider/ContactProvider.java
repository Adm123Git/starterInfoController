package ru.adm123.starterInfo.provider;

import ru.adm123.starterInfo.model.Contact;

/**
 * Класс, предоставляющий данные о контактах, относящихся к сервису
 */
public interface ContactProvider {

    /**
     * Отдает контакты разработчика
     *
     * @return {@link Contact}
     */
    Contact getDevelopContact();

    /**
     * Отдает контакты техподдержки
     *
     * @return {@link Contact}
     */
    Contact getSupportContact();

}
