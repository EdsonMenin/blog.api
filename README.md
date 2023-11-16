# Blog Spring

# Pré-requisitos

- Java Development Kit (JDK) 11 - [Download][1]
- Maven - [Download][2]
- Banco de dados PostgreSQL

[1]: https://www.oracle.com/java/technologies/downloads/#java11
[2]: https://maven.apache.org/download.cgi

Configuração
Clonar o repositório:

```bash
  git clone https://github.com/EdsonMenin/blog.api.git
```

# Configuração do banco de dados:

- Crie um banco de dados vazio (se ainda não existir).
- Configure as credenciais do banco de dados no arquivo application.properties.

# Execução
Compilar o projeto:

```bash
cd blog.api
mvn clean package -DskipTests
```

Executar o projeto:

```bash
java -jar target/blog-0.0.1-SNAPSHOT.jar
```