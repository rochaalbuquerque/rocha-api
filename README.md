# rocha-api


## MYSQL database

```
spring.datasource.url=jdbc:mysql://localhost:3306/rocha?useTimezone=true&serverTimezone=America/Sao_Paulo
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=${MYSQL_LOCAL_USER}
spring.datasource.password=${MYSQL_LOCAL_PASSWORD}
spring.datasource.testWhileIdle=true
spring.datasource.validationQuery=SELECT 1
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.naming-strategy=org.hibernate.cfg.ImprovedNamingStrategy

# LOG
logging.level.org.hibernate.SQL=DEBUG
logging.level.root=INFO
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

## Mongo DB database

```
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=rocha
#spring.data.mongodb.username=root
#spring.data.mongodb.password=root
```

## Swagger 3

```
Swagger 3 and Spring Boot example (with OpenAPI 3)
https://www.baeldung.com/spring-rest-openapi-documentation
```

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

## Configure from 17 to 21

```
<properties>
    <java.version>21</java.version>
</properties>

Configuração Global do Workspace:

Vá para Window > Preferences > Java > Installed JREs.
Adicione a JRE 21, caso ainda não esteja, e defina-a como padrão.
```

## Semantic Commit Messages

```

feat: (new feature for the user, not a new feature for build script)
fix: (bug fix for the user, not a fix to a build script)
docs: (changes to the documentation)
style: (formatting, missing semi colons, etc; no production code change)
refactor: (refactoring production code, eg. renaming a variable)
test: (adding missing tests, refactoring tests; no production code change)
chore: (updating grunt tasks etc; no production code change)

```
