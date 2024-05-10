## Endpoints

por: Verônica Medeiros
 
_Aplicação feita com base no repositório do back-end do Linketinder. Esta aplicação roda no servidor local criado com TomCat e está integrada ao banco de dados. Inicialmente foram criados três endpoints para serem utilizados com o método POST com intuito de cadastro de candidatos, empresas e vagas, sendo eles:_

- http://localhost:8081/linketinder/candidate
- http://localhost:8081/linketinder/company
- http://localhost:8081/linketinder/vacancy

_Para o envio de requisição, pode-se utilizar os comandos abaixo no terminal (os exemplos abaixo já estão com valor atribuído):_

_Requisição para criação de candidato:_

 ```
curl -X POST -H "Content-Type: application/json" -d '{
  "name": "João",
  "surname": "Silva",
  "birth": "1990-05-10",
  "email": "joao.silva@example.com",
  "country": "Brazil",
  "cep": "12345-678",
  "state": "São Paulo",
  "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
  "age": 34,
  "cpf": "123.456.789-00",
  "skills": [1, 2, 3],
  "password": "senha123"
}
' http://localhost:8081/linketinder/candidate
```


_Requisição para criação de empresa:_

 ```
curl -X POST -H "Content-Type: application/json" -d '{
  "name": "Tech",
  "email": "contato@tech.com",
  "country": "Brasil",
  "cep": "09856-569",
  "state": "Bahia",
  "description": "Nossa empresa é...",
  "cnpj": "15.458.168/0001-09",
  "password": "1a25d65d"
}' http://localhost:8081/linketinder/company
```


_Requisição para criação de vaga:_

 ```
 curl -X POST -H "Content-Type: application/json" -d '{
  "position": "Desenvolvedor Front-end",
  "level": "Júnior",
  "shift": "Meio período",
  "model": "Presencial",
  "city": "Rio de Janeiro",
  "state": "Rio de Janeiro",
  "jobDescription": "Estamos em busca de um desenvolvedor front-end apaixonado por tecnologia para fazer parte da nossa equipe e contribuir com o desenvolvimento de interfaces incríveis.",
  "desiredSkills": [7, 8, 9],
  "idCompany": 4
}
' http://localhost:8081/linketinder/vacancy
```
