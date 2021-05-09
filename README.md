# GIF RECEIVER
***
## Stack
***
* Open JDK 11
* Spring Boot web
* Spring Cloud openfeign
* Lombok
* Swagger
***
## Описание / Description:
###### RUSSIAN
```
Создать сервис, который обращается к сервису курсов валют, и отдает gif в ответ:

если курс по отношению к рублю за сегодня стал выше вчерашнего,  
то отдаем рандомную отсюда https://giphy.com/search/rich  
если ниже - отсюда https://giphy.com/search/broke  
Ссылки  
REST API курсов валют - https://docs.openexchangerates.org/  
REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide  
Must Have  
Сервис на Spring Boot 2 + Java / Kotlin  
Запросы приходят на HTTP endpoint, туда передается код валюты  
Для взаимодействия с внешними сервисами используется Feign  
Все параметры (валюта по отношению к которой смотрится курс,   
адреса внешних сервисов и т.д.) вынесены в настройки  
На сервис написаны тесты   
(для мока внешних сервисов можно использовать @mockbean или WireMock)   
Для сборки должен использоваться Gradle  
Результатом выполнения должен быть репо на GitHub с инструкцией по запуску  
Nice to Have  
Сборка и запуск Docker контейнера с этим сервисом
```  

###### ENGLISH
```
Create a service that accesses the exchange rate service, and returns gif in response:

if the exchange rate against the ruble today was higher than yesterday,  
we give a random one from here https://giphy.com/search/rich  
if lower - from here https://giphy.com/search/broke
Links
REST API for exchange rates - https://docs.openexchangerates.org/  
REST API for gifs - https://developers.giphy.com/docs/api#quick-start-guide
Must Have
Service in Spring Boot 2 + Java / Kotlin
Requests come to the HTTP endpoind, the currency code is passed there
To interact with external services Feign is used
All the parameters (currency against which exchange rates are viewed,   
external service addresses, etc.) are placed in the settings
Tests are written for the service
(@mockbean or WireMock can be used to bridge external services)   
Gradle should be used for building  
The result should be a repo on GitHub with instructions on how to run project 
Nice to Have  
Building and running a Docker container with this service
```
***
## How to run project
***
Build the project: `gradlew clean build`    
Run: `java -jar ./build/libs/alfa-bank-gif-receiver-1.0.0.jar`
***
Build docker container: `docker build -t alfa-bank-gif-receiver:1.0.0`  
Run docker container: `docker run --publish 8080:8080 alfa-bank-gif-receiver:1.0.0`
***
## Endpoint
***
* `/api`    
  Returns a gif depending on the exchange rate  
  **Parameters**    
  base:string(USD) - *USD by default*   
  **Example**   
  http://localhost:8080/api?base=USD