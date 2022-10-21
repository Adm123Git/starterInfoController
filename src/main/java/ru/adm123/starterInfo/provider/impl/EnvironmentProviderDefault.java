package ru.adm123.starterInfo.provider.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import ru.adm123.starterInfo.model.EnvironmentInfo;
import ru.adm123.starterInfo.provider.EnvironmentProvider;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Дефолтная реализация {@link EnvironmentProvider}
 */
@RequiredArgsConstructor
@ConditionalOnMissingBean(EnvironmentProvider.class)
public class EnvironmentProviderDefault implements EnvironmentProvider, CommandLineRunner {

    @Getter
    private final EnvironmentInfo environmentInfo = new EnvironmentInfo();
    private final StandardEnvironment environment;

    @Override
    public void run(String... args) {
        defineActiveProfileAndSystem();
    }

    private void defineActiveProfileAndSystem() {
        String[] activeProfilesArray = environment.getActiveProfiles();
        environmentInfo.setActiveProfile(Arrays.toString(activeProfilesArray));
        if (activeProfilesArray.length > 0) {
            String systemByProfile = getSystemByProfile(activeProfilesArray[0]);
            String system = systemByProfile == null
                    ? Arrays.toString(activeProfilesArray)
                    : systemByProfile;
            environmentInfo.setSystem(system);
        }
    }

    @Nullable
    private String getSystemByProfile(@NonNull String profile) {
        String preProdRegex = "^(d02.*\\d)$";
        String devRegex = "^(c00.*\\dt)$";
        String testRegex = "^(d02.*\\dt)$";
        String prodRegex = "^(d02.*\\dp)$";
        if (profile.equals("dev")) {
            return "dev";
        }
        if (Pattern.matches(profile, prodRegex)) {
            return "prod";
        }
        if (Pattern.matches(profile, preProdRegex)) {
            return "preprod";
        }
        if (Pattern.matches(profile, testRegex)) {
            return "test";
        }
        if (Pattern.matches(profile, devRegex)) {
            return "c00";
        }
        return null;
    }

}
