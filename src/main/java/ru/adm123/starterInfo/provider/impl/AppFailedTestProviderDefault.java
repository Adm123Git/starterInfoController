package ru.adm123.starterInfo.provider.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;
import ru.adm123.starterInfo.provider.AppFailedTestProvider;

import java.util.Collections;
import java.util.List;

/**
 * Дефолтная реализация {@link AppFailedTestProvider}
 */
@Component
@ConditionalOnMissingBean(AppFailedTestProvider.class)
public class AppFailedTestProviderDefault implements AppFailedTestProvider {

    @Override
    public List<String> getFailedTest() {
        return Collections.emptyList();
    }

}
