## ApiRest - Modelo de maturidade de Richardson para APIs REST

Para padronizar e facilitar o desenvolvimento de APIs REST, Leonard [Richardson](https://martinfowler.com/articles/richardsonMaturityModel.html) propôs um modelo de maturidade para esse tipo de API, definido em 4 níveis para ser restfull.

## Nível 0

Esse é considerado o nível mais básico e uma API que implementa apenas esse nível não pode ser considerada REST. Nesse nível os nomes dos recursos não seguem qualquer padrão e estão sendo usados apenas para fazer invocação de métodos remotos. Nesse nível usamos o protocolo HTTP para comunicação, mas sem seguir qualquer tipo de regras para implementar os métodos.

```markdown
| Verbo HTTP | URI            | Operação              |
| ---------- | -------------- | --------------------- |
| GET        | /getProdutos   | Buscar todos Produtos |
| POST       | /salvarProduto | Cria um Produto       |
```

## Nível 1 — Recursos (Resources)

Nesse nível fazemos uso de recursos para modelar a API, para representar cada recurso fazemos uso de substantivos no plural. No exemplo do crud de cliente, os recursos seriam identificados pelo substantivo “produtos”.

```markdown
| Verbo HTTP | URI         | Operação              |
| ---------- | ----------- | --------------------- |
| GET        | /produtos   | Buscar todos Produtos |
| POST       | /produtos   | Cria um Produto       |
| PUT        | /produtos/1 | Altera um Produto     |
| DELETE     | /produtos/1 | Apaga um Produto      |
```

## Nível 2 — Verbos HTTP

Como já foi adiantado no nível 1, o nível 2 se encarrega de garantir que os verbos HTTP sejam usados de forma correta. Os verbos mais utilizados são GET, POST, PUT e DELETE.
Os métodos GET, PUT e DELETE são considerados idempotente. Um método é considerado idempotente quando uma requisição idêntica pode ser executada várias vezes sem alterar o estado do servidor.

```markdown
| Verbo HTTP | Função          |
| ---------- | --------------- |
| GET        | Recuperar dados |
| POST       | Salvar dados    |
| PUT        | Alterar dados   |
| DELETE     | Excluir dados   |
```

## Nível 3 — HATEOAS

O nível 3 é sem dúvidas o menos explorado, muitas APIs existentes no mercado não implementam esse nível.
HATEOAS significa _Hypermedia as the Engine of Application State._ Uma API que implementa esse nível fornece aos seus clientes links que indicarão como poderá ser feita a navegação entre seus recursos. Ou seja, quem for consumir a API precisará saber apenas a rota principal e a resposta dessa requisição terá todas as demais rotas possíveis.
{
"id": 1,
"nome": "samsung s8",
"quantidade": 1.00,
"valor": 2599.00,
"links": [
{
"rel": "self",
"href": "http://localhost:8080/api/produto/1"
}

### Referências

https://martinfowler.com/articles/richardsonMaturityModel.html

### Tecnologias

- Jpa
- swagger
- dto
- repository
- service
- postgresql
- postman
- lombok
- hateoas

#### Citação

“A conquista vem quando você cancela as desculpas e transforma adversidade em ação. Todo dia faça algo que te deixe mais perto dos seus objetivos".
