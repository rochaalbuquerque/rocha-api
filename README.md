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
## WSL / DOCKER / DOXKER-COMPOSE / IMG MYSQL / IMG MONGO

```
	WSL:
		usuario: wsl
		senha/; wsl
	
	
	INCIO:
		wsl
		docker ps
	
	MYSQL:
		sudo docker run --name mysql_db -e MYSQL_ROOT_PASSWORD=root -d mysql:latest
		sudo docker exec -it mysql_db mysql -uroot -p
		
		docker stop mysql_db
		docker run mysql_db
		docker rm msql_db_3306
		docker rename mysql_db mysql_db_old
		
		
		SHOW DATABASES;
		USE rocha;
		SHOW TABLES;
		SELECT * FROM nome_da_tabela;
		
		CREATE DATABASE rocha;
		DELETE FROM flyway_schema_history WHERE version = '1';
		
		CREATE TABLE IF NOT EXISTS rocha_client (
	    id INT PRIMARY KEY,
	    cpf_ou_cnpj VARCHAR(20),
	    email VARCHAR(50),
	    first_name VARCHAR(50),
	    last_name VARCHAR(50)
	);
	
	
		
	
		
		Porta MYSQL:
			sudo docker run -d --name mysql_db -e MYSQL_ROOT_PASSWORD=root -p 3307:3306 mysql:latest
	
	
	MONGO:
		docker exec -it mongo_db mongosh
		show databases;
		use nome_do_banco;
		db.nome_da_colecao.find().pretty();
	
	
	CAMINHOS:
		cd /mnt/d/projects/rocha-api/src/main/resources
		cd /mnt/c/Users/Rocha
	
	
	COMPOSE:
		docker-compose -f /mnt/d/projects/rocha-api/src/main/resources/docker-compose.yml up -d
		ou
		cd /mnt/d/projects/rocha-api/src/main/resources
		ls
		docker compose up -d
		
	DOCKER:
		docker inspect mysql_db | grep IPAddress

```

