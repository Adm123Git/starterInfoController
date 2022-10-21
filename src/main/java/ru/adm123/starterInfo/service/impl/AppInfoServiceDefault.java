package ru.adm123.starterInfo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import ru.adm123.starterInfo.configuration.ElasticProperties;
import ru.adm123.starterInfo.configuration.F130Properties;
import ru.adm123.starterInfo.model.dto.SelfTest;
import ru.adm123.starterInfo.model.dto.State;
import ru.adm123.starterInfo.model.dto.Version;
import ru.adm123.starterInfo.provider.*;
import ru.adm123.starterInfo.service.AppInfoService;

@RequiredArgsConstructor
@ConditionalOnMissingBean(AppInfoService.class)
@EnableConfigurationProperties({ElasticProperties.class, F130Properties.class})
public class AppInfoServiceDefault implements AppInfoService {

    private final AppVersionProvider appVersionProvider;
    private final AppNameProvider appNameProvider;
    private final ContactProvider contactProvider;
    private final EnvironmentProvider environmentProvider;
    private final AppFailedTestProvider appFailedTestProvider;
    private final ElasticProperties elasticProperties;
    private final F130Properties f130Properties;

    @Override
    public Version getVersion() {
        return new Version(appVersionProvider.getAppVersion());
    }

    @Override
    public State getState() {
        return new State()
                .setService(appNameProvider.getServiceName())
                .setType(appNameProvider.getServiceType())
                .setName(appNameProvider.getAppName())
                .setDevelop(contactProvider.getDevelopContact())
                .setSupport(contactProvider.getSupportContact())
                .setSystem(environmentProvider.getEnvironmentInfo().getSystem())
                .setVersion(appVersionProvider.getAppVersion())
                .setActiveProf(environmentProvider.getEnvironmentInfo().getActiveProfile())
                .setElasticHost(elasticProperties.getHostname())
                .setF130AdminHost(f130Properties.getHosturl());
    }

    @Override
    public SelfTest getSelfTest() {
        return new SelfTest()
                .setFailedTests(appFailedTestProvider.getFailedTest())
                .setVersion(appVersionProvider.getAppVersion())
                .setActiveProf(environmentProvider.getEnvironmentInfo().getActiveProfile())
                .setElasticHost(elasticProperties.getHostname())
                .setF130AdminHost(f130Properties.getHosturl());
    }

}
