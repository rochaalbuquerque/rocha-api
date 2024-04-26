# rocha-api

Swagger 3 and Spring Boot example (with OpenAPI 3)

## Configure MySQL

1. Using a database MySQL

## Configure Flyway Migration

```
Maven:

<dependency>
	<groupId>org.flywaydb</groupId>
	<artifactId>flyway-mysql</artifactId>
</dependency>

propertie:

spring.flyway.baselineOnMigrate=true
spring.flyway.locations=classpath:db/migration
spring.flyway.schemas=data_base
spring.flyway.enabled=true
```

## Ehcache versão 3

```
https://www.baeldung.com/spring-boot-ehcache
https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/html/boot-features-caching.html

```
