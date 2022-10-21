package ru.adm123.starterInfo.service;


import ru.adm123.starterInfo.model.dto.SelfTest;
import ru.adm123.starterInfo.model.dto.State;
import ru.adm123.starterInfo.model.dto.Version;

public interface AppInfoService {

    Version getVersion();

    State getState();

    SelfTest getSelfTest();

}
