package ru.adm123.starterInfo.provider.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import ru.adm123.starterInfo.provider.AppNameProvider;

/**
 * Дефолтная реализация {@link AppNameProvider}
 */
@ConditionalOnMissingBean(AppNameProvider.class)
public class AppNameProviderStub implements AppNameProvider {

    @Override
    public String getAppName() {
        return "";
    }

    @Override
    public String getServiceName() {
        return "";
    }

    @Override
    public String getServiceType() {
        return "";
    }

}
