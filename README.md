### API-PRODUTO FUNCIONALIDADES
A nossa api tem 4 funções principais sendo elas get, post, put, delete. Como o nosso projeto é um cardápio digital, temos a função get, para quando o usuário clicar no botão fazer a requisição dos preços dos produtos cadastrados, então quando clicar no botão irá mostrar o preço do respectivo produto escolhido.

Ao produto ser escolhido e adicionado na lista de pedidos, fazemos mais uma nova requisição get para mostrar o preço na outra tela. Usamos o put para atualizar o preço da lista, pois a cada produto selecionado pelo usuário o valor da lista se altera, então o put é para atualizar o valor total da compra.

Em relação ao delete, para caso o usuário queira retirar algum dos seus produtos da lista, usamos a api para deletar esse produto da lista e automaticamente o put é feito dando o novo preço da lista.

Estamos usando api nesse projeto pois sabemos que o restaurante sempre atualiza seus preços devido a mudança de preço dos produtos, então para não ter que alterar o preço diretamente no código, dar deploy, conseguimos alterar via api de forma muito mais fácil.



## MOTIVAÇÃO
- Criar uma API para ser consumida no front end, com persistência de dados no Banco da Oracle SQL.
- API com 2 entidades Produto, Pedido.
- As 2 entidades precisam possuir recursos dos verbos comuns em uma aplicação rest: GET, POST, DELETE e PUT.


## ENDPOINTS

* Listar produto e/ou pedido<br></br>
GET http://localhost:8080/produto<br></br>
GET http://localhost:8080/pedido<br></br>


* Detalhes do produto e/ou pedido<br></br>
GET http://localhost:8080/produto/1<br></br>
GET http://localhost:8080/pedido/1<br></br>


* Listar o produto pelo nome<br></br>
GET http://localhost:8080/produto/pesquisa/{NOME}<br></br>


* Apagar produto e/ou pedido<br></br>
DELETE http://localhost:8080/produto/1<br></br>
DELETE http://localhost:8080/pedido/1<br></br>


* Cadastrar produto e/ou pedido<br></br>
POST http://localhost:8080/produto<br></br>
POST http://localhost:8080/pedido<br></br>


* Alterar produto e/ou pedido<br></br>
POST http://localhost:8080/produto/1<br></br>
POST http://localhost:8080/pedido/1<br></br>

