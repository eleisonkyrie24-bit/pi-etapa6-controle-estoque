# Registro de refatoração

## Situação inicial

Como as etapas anteriores do PI não foram realizadas, foi elaborado nesta etapa um protótipo monolítico mínimo (`docs/versao-inicial/EstoqueAppMonolitico.java.txt`) apenas para servir como referência de refatoração.

## Code smells identificados

1. **God Class / baixa coesão**: uma classe concentrava validação, persistência, regras e apresentação.
2. **Método longo**: `executar(...)` continha vários fluxos independentes.
3. **Acoplamento forte**: a regra de negócio dependia diretamente de `HashMap` e `ArrayList`.
4. **Magic strings**: operações eram identificadas por `"CADASTRAR"`, `"ENTRADA"` e `"SAIDA"`.
5. **Tratamento de erro por impressão**: regras inválidas eram tratadas com `System.out.println`, dificultando reutilização em web.
6. **Uso de `double` para dinheiro**: substituído por `BigDecimal`.

## Refatorações

- **Extract Class**: domínio, repositórios e serviços foram separados.
- **Extract Method**: validações pequenas foram extraídas em `ProdutoService`.
- **Replace Magic String with Enum**: `TipoMovimentacao`.
- **Introduce Interface**: `ProdutoRepository` e `MovimentacaoRepository`.
- **Dependency Injection via constructor**: serviços recebem os repositórios no construtor.
- **Replace Error Code/Print with Exception**: `RegraNegocioException` e `ProdutoNaoEncontradoException`.
- **Replace Primitive**: valores monetários usam `BigDecimal`.

## Padrão Repository

A persistência foi encapsulada por interfaces. A implementação atual é em memória, mas uma implementação JDBC/JPA poderá ser criada sem alterar os serviços, desde que respeite os contratos.
