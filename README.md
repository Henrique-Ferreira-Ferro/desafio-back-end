# Desafio back-end para desenvolvedores iniciantes

Este é o desafio para quem deseja uma revisão/mentoria.

Como isso vai funcionar:
- Isto não é um processo seletivo.
- Farei um code review.
- Darei feedback com sugestão de estudos e pontos de atenção.
- Marcaremos uma chamada 1:1 para tirar dúvidas e entender o raciocínio que levou à implementação.

O desafio deve ser escrito em umas das opções
1) Java 8+ com Spring Framework.
2) C# com framework de sua preferência.

# O Desafio

Precisamos de uma API que sirva o back-end de uma aplicação de aluguel de carros. Essa API precisa ser capaz de:

- Cadastrar um carro/cliente
- Editar um carro/cliente
- Deletar um carro/cliente
- Listar os carros/clientes
- Obter informações de um carro/cliente por ID

A entidade `carro` deve ter os seguintes campos:

- id -> Identificador do carro.
- marca -> Marca do carro.
- modelo -> Modelo do carro.
- dataCadastro -> Data em que o carro foi cadastrado.

A entidade `cliente` deve ter os seguintes campos:

- id -> Identificador do cliente.
- nome -> Nome do cliente (máx. de 50 caracteres)
- cpf -> CPF do cliente (deve ser único e não guardar pontos e traços).
- carro -> Carro alugado pelo cliente.
- dataNascimento -> Data de nascimento do cliente (formatada no padrão br: dd/MM/aaaa).
- created_at -> Data de criação do cliente.
- updated_at -> Data em que houve alteração no cliente.

Você pode utilizar qualquer banco, desde que ele seja [SQL](http://www.sqlcourse.com/intro.html).

## Requisitos

- Utilizar a nova [API de Data do Java](https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html)
- Todas as respostas precisam ser retornadas no formato [JSON](https://www.json.org/json-en.html).
- Crie um `README.md` com as informações de como usar sua aplicação. (Como executar, quais são as rotas etc)

## Diferenciais

- Banco em memória (H2).
- Clean code.
- Princípios SOLID.

## Como entregar o teste

1. Faça um fork desse repositório.
2. Resolva o desafio da melhor maneira que você puder.
3. Envie um pull-request para análise do resultado.


---------------------------------------------------------------------------------------------------------------------------------

### Como utilizar a aplicação 

### As Requisições do Cliente no Postman:

#### Procurar um Cliente por ID

`http://localhost:8080/cliente/1`

![image](https://github.com/Henrique-Ferreira-Ferro/desafio-back-end/assets/92760541/ea691a4f-553a-472d-b6d6-c84b6dafcf86)


#### Procurar todos os Clientes

`http://localhost:8080/cliente`

![image](https://github.com/Henrique-Ferreira-Ferro/desafio-back-end/assets/92760541/be385b68-4a30-44ce-a658-0645b15d37cb)

#### Criar um Cliente

`http://localhost:8080/cliente/create`

![image](https://github.com/Henrique-Ferreira-Ferro/desafio-back-end/assets/92760541/37cbadc4-3792-454a-b1e6-67bec39463e5)

#### Atualizar um Cliente por ID

`http://localhost:8080/cliente/update/68`

![image](https://github.com/Henrique-Ferreira-Ferro/desafio-back-end/assets/92760541/31e8e11c-3f2e-4320-8002-33ce08d81068)

#### Deletar um Cliente por ID

`http://localhost:8080/cliente/67`

![image](https://github.com/Henrique-Ferreira-Ferro/desafio-back-end/assets/92760541/ab206870-9e14-44db-8fd8-7633a11a81ff)


### As Requisições do Veiculo no Postman:

#### Criar um Veiculo associando a um Cliente

`http://localhost:8080/carro/create/33`

![image](https://github.com/Henrique-Ferreira-Ferro/desafio-back-end/assets/92760541/1289c0b3-7894-4f30-b904-1c79364dfc3f)

#### Atualizar um Veiculo por ID

`http://localhost:8080/carro/update/1`

![image](https://github.com/Henrique-Ferreira-Ferro/desafio-back-end/assets/92760541/650167c7-faac-4292-9a5d-04f99f272c2d)


#### Pesquisar um Veiculo por ID

`http://localhost:8080/carro/4`

![image](https://github.com/Henrique-Ferreira-Ferro/desafio-back-end/assets/92760541/e00dfbc2-1535-4906-976f-9127997ecdb6)


#### Pesquisar todos os Veiculos

`http://localhost:8080/carro

![image](https://github.com/Henrique-Ferreira-Ferro/desafio-back-end/assets/92760541/5092ad3c-08e9-4e9d-868f-431b93867b65)



