## StarterInfoController ##
Проект представляет собой `spring-boot-starter`, обеспечивающий "появление" в использующем его приложении end-point-ов,
отдающих инфу о состоянии приложения:
- ping
- version
- state
- selftest

### Использование ###
1. **Деплой**<br>
Для использования стартера в приложении первым делом нужно его собрать и задеплоить туда, откуда можно подключить
(например, в локальный `maven` - выполнить `mvn install`).

2. **Подключение**<br>
Стартер нужно подключить в `pom`-нике приложения:
```
<dependency>
    <groupId>ru.adm123</groupId>
    <artifactId>starter-infoController</artifactId>
    <version>0.0.1</version>
</dependency>
```
3. **Конфигурация приложения**<br>
- В файле конфигурации приложения нужно указать end-point-ы, которые мы 
хотим включить, а также параметры подключения приложения к эластику и сервису f130admin.<br>
Пример конфига приложения:
```
info-controller:
  end-point:
    version: true
    ping: true
    state: true
    selftest: true

elasticsearch:
  hostname: "elastichost.domain.ru"
  port: 9200
  schema: "http"

f130admin:
  hosturl: "http://f130adminhost.domain.ru:8080"
```
- Желательно в приложении реализовать интерфейсы, отвечающие за формирование данных, которые возвращают наши 
end-point-ы. Если этого не сделать, то вместо соответствующих данных отдаваться будут `null`-ы.<br>
Пример реализации:
```
@Configuration
public class InfoConfiguration {

    @Bean
    public AppVersionProvider appVersionProvider() {
        return () -> "1.2.3.4";
    }

    @Bean
    public AppNameProvider appNameProviderStub() {
        return new AppNameProvider() {

            @Override
            public String getAppName() {
                return "Суперсервис офигенный";
            }

            @Override
            public String getServiceName() {
                return "mega_service";
            }

            @Override
            public String getServiceType() {
                return "report";
            }

        };
    }

    @Bean
    public AppFailedTestProvider appFailedTestProvider() {
        return Collections::emptyList;
    }

}
```
### Результат ###
В приложении появятся end-point-ы, которые мы включили в конфиге, и при обращении к ним будут отдавать 
соответствующие данные.<br>
Swagger-доки на внедренные end-point-ы доступны по урлу `http://localhost:8080/swagger-ui/index.html` (при условии, 
что приложение развернуто на `localhost:8080`)

### Линк ###
Демо-апп - [здесь](https://github.com/Adm123Git/starterDemo)