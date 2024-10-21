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

## Strategy Pattern (Padrão de Projeto)

```
Strategy Pattern (Padrão de Projeto)
Se o código dentro dos blocos if-else é mais complexo e requer diferentes implementações, você pode utilizar o Strategy Pattern. Ele ajuda a separar as diferentes lógicas em classes distintas.
```

```
Criação do mapa de estratégias de pagamento:

O código cria um HashMap<PaymentType, PaymentStrategy>, que associa diferentes tipos de pagamento (PaymentType) às suas respectivas estratégias de processamento (PaymentStrategy).
São adicionadas três estratégias ao mapa: BoletoStrategy, PixStrategy, e CartaoStrategy, associadas a seus respectivos tipos de pagamento (BOLETO, PIX e CARTÃO).
Conversão de String para enum PaymentType:

O método getTypePayment() de orderDTO retorna o tipo de pagamento como uma String. Esse valor é convertido para um enum PaymentType usando o método valueOf().
A conversão usa toUpperCase() para garantir que o texto da String corresponda exatamente ao nome do enum, que é sensível a maiúsculas/minúsculas.
Tratamento de erros:

Se a String do tipo de pagamento não corresponder a nenhum valor do enum, uma exceção IllegalArgumentException será lançada, capturada e transformada em uma FileException com uma mensagem clara sobre o erro.
Processamento da estratégia de pagamento:

O código usa o valor convertido de PaymentType como chave para recuperar a estratégia de pagamento correspondente do mapa.
Se uma estratégia for encontrada, o método process() da estratégia é chamado para executar o processamento do pagamento.
Caso não haja uma estratégia associada ao tipo de pagamento fornecido, uma exceção FileException é lançada informando que o tipo de pagamento não é suportado.
Em resumo:
Esse trecho de código pega o tipo de pagamento de um pedido (orderDTO), converte-o para um enum, encontra a estratégia de pagamento correta no mapa e executa essa estratégia. Se o tipo de pagamento não for válido ou não suportado, ele lança uma exceção.

Links de referência dos estudos:
https://github.com/Flavio-Vieirastack/tips/tree/main/strategy-factory 
https://www.youtube.com/watch?v=DWoPsD_Aq2E
https://www.youtube.com/watch?v=69eI1fPGsZI&list=LL&index=2
https://refactoring.guru/design-patterns/strategy/java/example

```

