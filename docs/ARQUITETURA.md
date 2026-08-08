# Arquitetura do projeto

```text
Main
  |-- ProdutoService --------> ProdutoRepository <-------- InMemoryProdutoRepository
  |                                ^
  |                                |
  |-- EstoqueService --------------+
           |
           +--------------------> MovimentacaoRepository <--- InMemoryMovimentacaoRepository

ProdutoService / EstoqueService ---> Produto / MovimentacaoEstoque / TipoMovimentacao
```

A camada de apresentação futura (Swing, Servlet, REST Controller etc.) deverá chamar os serviços, sem inserir regras de negócio no código da tela.
