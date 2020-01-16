### Gonna to user Allure report in simple test scenarios


**Programming language:** 
* Java 


**Type of framework:** 
* Hybrid Driven Testing Framework (Linear, Module, KeyWord and Data driven frameworks are insdite)

**Test frameworks are used:** 
* TestNG
* WebDriver - Selenium


**Element locators are located:** 
* Page Object Pattern


**Property file:** 
* src/main/resources/canva.property (URLs, Credentials)
* scr/test/resources/allure.properties (Allure settings)


**Patterns are used:** 
* Page Object Pattern
* Steps pattern
* Chain of invocation pattern
* WebDriver Factory pattern


**Logger:**
* Decorator pattern - Log4J


### How to run:
```sh
- mvn clean test
- mvn io.qameta.allure:allure-maven:serve
```



