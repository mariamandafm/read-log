![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

## API Read-Log

A API Read-Log é uma API RESTful construída com Spring que permite aos usuários criar clubes de livros, adicionar membros aos clubes, definir a leitura atual e criar tópicos.

### Uso

1. **Criar um Clube**: Envie uma requisição POST para `/clubs` com os detalhes do clube no corpo da requisição.

2. **Adicionar Membro ao Clube**: Envie uma requisição POST para `/clubs/{idClub}/members/{idUser}` para adicionar um membro ao clube especificado.

3. **Definir Leitura Atual**: Envie uma requisição POST para `/clubs/{idClub}/reading` com o ID do clube na variável de path e os detalhes da leitura no corpo da requisição.

4. **Criar Tópico**(TO-DO): Envie uma requisição POST para `/clubs/{idClub}/topics` com o ID do clube na variável de path e os detalhes do tópico no corpo da requisição.

### Dependências

- Spring Boot
- Spring Data JPA
- Postgresql
- ModelMapper (para mapeamento entre DTOs e entidades)
- Lombok (para reduzir o código boilerplate)

### Executando a Aplicação
A aplicação será iniciada em `localhost:8080`
```
git clone https://github.com/mariamandafm/read-log.git
cd read-log
mvn spring-boot:run
```
