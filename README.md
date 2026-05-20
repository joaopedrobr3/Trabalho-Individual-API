

---

# 🐶 API - ONG de Adoção de Animais

Trabalho Prático Individual — Desenvolvimento de API RESTful com Spring Boot + PostgreSQL

👤 **Aluno:** João Pedro Carneiro Motta
🔗 **Repositório:** [github.com/joaopedrobr3/Trabalho-Individual-API](https://github.com/joaopedrobr3/Trabalho-Individual-API)

---

## 📋 Descrição

API RESTful desenvolvida para gerenciar uma ONG de adoção de animais. O sistema permite o cadastro de pessoas interessadas em adotar, animais disponíveis para adoção, endereços, características dos animais e registros de interesse de adoção.

---

## 🛠️ Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Data JPA / Hibernate
* PostgreSQL
* Maven
* Swagger / OpenAPI (springdoc-openapi)
* Bean Validation

---

## 📦 Estrutura de Pacotes

```
src/main/java/org/serratec/Ong/
├── controller/
├── service/
├── repository/
├── domain/
├── dto/
├── exception/
└── config/
```

---

## 🗂️ Entidades Principais

| Entidade          | Descrição                                               |
| ----------------- | ------------------------------------------------------- |
| `Pessoa`          | Pessoas interessadas em adotar animais                  |
| `Endereco`        | Endereço vinculado à pessoa                             |
| `Animal`          | Animais disponíveis para adoção                         |
| `Caracteristica`  | Características de personalidade e saúde dos animais    |
| `InteresseAdocao` | Registro de interesse de uma pessoa em adotar um animal |

---

## 🔗 Relacionamentos JPA

| Tipo                      | Entidades                                           |
| ------------------------- | --------------------------------------------------- |
| `@OneToOne`               | Pessoa ↔ Endereco                                   |
| `@OneToMany / @ManyToOne` | Pessoa → InteresseAdocao / Animal → InteresseAdocao |
| `@ManyToMany`             | Animal ↔ Caracteristica                             |

---

## 🚀 Como Rodar o Projeto

### Pré-requisitos

* Java 17+
* Maven
* PostgreSQL instalado e rodando

### Passo a passo

1. Clone o repositório:

```bash
git clone https://github.com/joaopedrobr3/Trabalho-Individual-API.git
cd Trabalho-Individual-API
```

2. Crie o banco de dados no PostgreSQL:

```sql
CREATE DATABASE ong;
```

3. Configure o arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ong
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

4. Execute o projeto:

```bash
mvn spring-boot:run
```

5. Acesse a documentação do Swagger:

```
http://localhost:8080/swagger-ui.html
```

---

# 📖 Endpoints

## 🐶 Animais — `/animais`

### Exemplo de POST:

```json
{
  "nome": "Rex",
  "sexo": "MACHO",
  "porte": "MEDIO",
  "especie": "CANINO",
  "idcaracteristica": [1]
}
```

---

## 👤 Pessoas — `/pessoas`

### Exemplo de POST:

```json
{
  "nome": "João Silva",
  "cpf": "12345678901",
  "telefone": "2199999999",
  "email": "joao@email.com",
  "dataNascimento": "2000-05-10",
  "idEndereco": 1
}
```

---

## 🏠 Endereços — `/enderecos`

### Exemplo de POST:

```json
{
  "cidade": "Rio de Janeiro",
  "rua": "Rua das Flores",
  "bairro": "Centro",
  "numero": 123
}
```

---

## 🏷️ Características — `/caracteristicas`

### Exemplo de POST:

```json
{
  "personalidade": "AMIGAVEL",
  "saude": "JOVEM_SAUDAVEL"
}
```

---

## 💛 Interesses de Adoção — `/interesses`

### Exemplo de POST:

```json
{
  "motivacao": "Tenho muito espaço em casa e amo animais.",
  "tipoMoradia": "CASA",
  "idPessoa": 1,
  "idAnimal": 1
}
```

---

## ⚠️ Tratamento de Erros

| Status | Situação                                               |
| ------ | ------------------------------------------------------ |
| 400    | Dados inválidos ou campos obrigatórios não preenchidos |
| 404    | Recurso não encontrado                                 |
| 409    | Conflito (dados duplicados, como CPF)                  |

---

## 📌 Observações

* Não é necessário autenticação para utilizar a API
* Todos os endpoints estão documentados e testáveis via Swagger em `/swagger-ui.html`
* Não é possível inserir **Pessoa sem Endereço cadastrado**
* Não é possível inserir **Animal sem Características cadastradas**
* Todos os endpoints possuem operações CRUD completas

---


