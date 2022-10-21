package ru.adm123.starterInfo.provider.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import ru.adm123.starterInfo.model.Contact;
import ru.adm123.starterInfo.provider.ContactProvider;

/**
 * Дефолтная реализация {@link ContactProvider}
 */
@ConditionalOnMissingBean(ContactProvider.class)
public class ContactProviderDefault implements ContactProvider {

    public static final Contact DEVELOP = new Contact()
            .setName("ЦАИТС - АО «Почта России»")
            .setPhone("8-812-327-39-70")
            .setEmail("itsm.support-c00@russianpost.ru")
            .setWeb("www.pochta.ru");

    public static final Contact SUPPORT = new Contact()
            .setName("ЦАИТС - АО «Почта России»")
            .setPhone("8-812-327-39-70")
            .setEmail("itsm.support-c00@russianpost.ru")
            .setWeb("www.pochta.ru");

    @Override
    public Contact getDevelopContact() {
        return DEVELOP;
    }

    @Override
    public Contact getSupportContact() {
        return SUPPORT;
    }

}
