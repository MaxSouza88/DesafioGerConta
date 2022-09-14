# DesafioGerConta

Desafio Gerenciador de contas.

Faça uma API para gerenciar as terríveis contas que devemos pagar todos os meses. Essa API deve funcionar como um organizador, dessa forma ela vai permitir cadastrar, visualizar, atualizar e deletar contas do sistema (nosso famoso CRUD).

Nome do banco: gerenciador

Cadastrando a conta:
Toda conta do sistema deve ter:
Uma class status: ENUM.  (AGUARDANDO, PAGO e VENCIDA)
Outra class tipo: ENUM. (LUZ, AGUA, COMIDA, LASER e OUTROS)

Class Model ContasAPagar.
nome: String
valor: double
dataDeVencimento: LocalDate
dataDePagamento: LocalDateTime


Para cadastrar uma conta a requisição deve seguir o seguinte padrão:

Endpoint: /contas
Verbo HTTP: POST
corpo:
{
"nome": "ENEL",
"valor": 190.00,
"tipo": "LUZ",
"dataDeVencimento": "2021-11-27"
}

a resposta deve ser:
STATUS 201
corpo:
{
"id": 1,
"nome": "ENEL",
"valor": 190.00,
"tipo": "LUZ",
"dataDeVencimento": "2021-11-27",
"dataDePagamento": null
"status": "Aguardando"
}

Os Enum;

O enum de Status deve conter as opções; AGUARDANDO, PAGO e VENCIDA;
O enum de Tipo deve conter as opções; LUZ, AGUA, COMIDA, LASER e OUTROS

Entrega Mínima:

O sistema deve permitir que uma conta seja cadastrada no sistema. Sempre que uma conta com a data de vencimento for anterior ao dia do cadastro será preenchido AUTOMATICAMENTE pelo sistema o STATUS VENCIDA, em todos os outros casos o STATUS padrão para as contas novas cadastradas é de AGUARDANDO.

O Sistema também deve permitir visualizar a lista com todas as contas. Essa lista deve conter apenas os campos ID, Nome, Valor, Status.
Por fim, o sistema deve permitir fazer uma requisição para informar que a conta foi paga. Essa requisição deve seguir o seguinte padrão.

Endpoint: /contas/{id}
Verbo HTTP: PUT
{
"status":"PAGO"
}

a resposta:
Status 200
{
"id": 1,
"nome": "ENEL",
"valor": 190.00,
"tipo": "LUZ",
"dataDeVencimento": "2021-11-27",
"dataDePagamento": “2021-11-10 10:00:00”
"status": "PAGO"
}

IMPORTANTE: SEMPRE QUE UMA CONTA FOR PAGA O CAMPO dateDePagamento DEVE SER PREENCHIDA PELO SISTEMA

Entrega MÉDIA

O sistema realiza todas as validações de campos obrigatórios para cadastrar uma conta. São eles; NOME, VALOR, TIPO e Data de Vencimento.
O sistema responderá de forma coerente todos os erros de validação como por exemplo 422 para erros causados por validação ou 404 quando cliente tentar atualizar uma conta que não existe.

Para isso será necessário o controller advice.

O sistema também permitirá visualizar uma conta específica com todos os detalhes.

IMPORTANTE: Entrega média válida APENAS se a mínima estiver perfeita.
Entrega Maxima.

O sistema deve permitir que sejam feitos alguns filtros na lista de contas.

1 - filtro de contas por status
2 - filtro de contas por tipo

Por fim, o sistema deve permitir DELETAR uma conta caso seja necessário. A requisição deve seguir o seguinte padrão.

Endpoint: /contas/{id}
Verbo HTTP: DELETE

Resposta Status 204

IMPORTANTE: Entrega máxima válida APENAS se a média estiver perfeita.

Continuação - parte 2.
Não mude os nomes dos atributos e classes - é essencial para a correção.
Se seu contas ContasAPagar ou Enums tiverem outros nomes diferentes coloque os da documentação.
Crie as classes relacionamentos e os CRUDS.

Todos os foreign deverão ter o final _id ex: Classe Avião terá o passageiro_id. Primary key terão o nome de código.

Crie uma classe Usuario:
nomeUsuario: String
dataNascimento: Date
email - String -validation
CPF - String - validation
Depois da validação se precisar para teste número de cpf use o site https://www.4devs.com.br/gerador_de_cpf


Crie uma classe Endereco:
logradouro: String
Bairro: String
cep: String
pontoReferencia: String

Crie uma classe Cidade:
nomeCidade: String

Crie uma classe Estado:
uf: String
nomeEstado: String

Nosso Usuario tem seu contasReceber;

ContasReceber:
Status String, recebimento String, valorRecebido BigDecimal, tipoRecebido ENUM, dataDeVencimento Date, dataDeRecebimento Date, usuario_id.


{
"id": 1,
"recebimento": "ALUGUEL CASA 1",
"valorRecebimento": 970.00,
"TipoRebimento": "ALUGUEIS",
"dataDeVencimento": "2022-09-11",
"dataDeRecebimento": “2021-11-10 10:00:00”,
"status": "PAGO",
“usuarios_id”: “1”
}

Enun TipoRecebimento: “ALUGUEIS, EMPREGO_CLT, FREELANCER"
Enun RecebimentoAlugueis: “EM_ATRASO, EM_DIA”, ADIANTADO”.
Entrega Mínima:
Patterns Factory.
Quando for recebimento de aluguéis.
Os aluguéis em contratos tem os seguintes critérios - em atraso multa de 3,5%, em dia sem desconto e adiantado 5% de desconto.

Entrega MÉDIA

O sistema realiza todas as validações de campos obrigatórios para cadastrar uma conta. São eles; nomeUsuario, VALORDERECEBIMENTO, TIPORECEBIMENTO e Data de Vencimento.
Pesquisa por todos os “usuários” não mostra cpf.
O sistema responderá de forma coerente todos os erros de validação como por exemplo 422 para erros causados por validação ou 404 quando usuário tentar atualizar uma conta que não existe.

Para isso será necessário o controller advice.

O sistema também permitirá visualizar uma TipoRecebimento específica com todos os detalhes.
Entrega Maxima.

O sistema deve permitir que sejam feitos alguns filtros na lista de contas.

1 - filtro de contas por status -contasReceber
2 - filtro de contas por TIPORECEBIMENTO - contasReceber
3 -Data de vencimento a partir de: - contasReceber

Por fim, o sistema deve permitir DELETAR uma conta caso seja necessário. A requisição deve seguir o seguinte padrão.

Endpoint: /contasReceber/{id}
Verbo HTTP: DELETE

Resposta Status 204

