package ru.adm123.starterInfo.provider.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import ru.adm123.starterInfo.provider.AppVersionProvider;

/**
 * Дефолтная реализация {@link AppVersionProvider}
 */
@ConditionalOnMissingBean(AppVersionProvider.class)
public class AppVersionProviderStub implements AppVersionProvider {

    @Override
    public String getAppVersion() {
        return "";
    }

}
