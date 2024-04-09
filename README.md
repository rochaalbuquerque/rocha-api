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
