# PLANO DE TESTES — PI ETAPA 7

## Sistema de Controle de Estoque

**Aluno:** Matheus França Lopes Martins  
**Curso:** Projeto Integrador Assistente de Desenvolvimento de Sistemas II  
**Unidade Curricular:** UC15  
**Professor:** Lucas Fraga  
**Ano:** 2026

## 1. Objetivo

Este plano define os testes básicos do Sistema de Controle de Estoque desenvolvido na Etapa 6 e preparado para futura interface web. O objetivo é verificar as principais regras de negócio, reduzir regressões durante a migração para web e registrar quais cenários devem ser executados de forma automatizada com JUnit e quais devem ser verificados manualmente na camada de apresentação.

## 2. Escopo

Estão incluídos no plano:

- cadastro de produtos;
- normalização e unicidade de SKU;
- validação de nome e preço;
- consulta e listagem de produtos;
- alteração de preço;
- entrada e saída de estoque;
- bloqueio de saldo negativo;
- histórico de movimentações;
- cálculo do valor financeiro do estoque;
- exclusão condicionada ao saldo zero;
- comportamento básico previsto para a futura interface web.

Não fazem parte deste plano, neste momento, testes de autenticação, autorização, integração com fornecedores ou banco de dados persistente, pois essas funcionalidades ainda não pertencem ao escopo implementado.

## 3. Estratégia de testes

### 3.1 Testes unitários automatizados

Os testes JUnit devem validar regras de negócio isoladas ou com dependências substituídas por implementações em memória. O projeto utiliza JUnit Jupiter e Maven Surefire. Os testes ficam em `src/test/java` e podem ser executados no NetBeans ou por `mvn test`.

Classes cobertas nesta etapa:

- `ProdutoTest`: cálculo financeiro e invariantes locais de estoque;
- `ProdutoServiceTest`: cadastro, normalização de SKU, duplicidade e preço;
- `EstoqueServiceTest`: movimentações, histórico e valor total do estoque.

### 3.2 Testes manuais

Os testes manuais verificam fluxos completos e, posteriormente, a camada web. Na etapa web, deverão ser conferidos formulários, mensagens de validação, atualização visual dos saldos e navegação entre cadastro, listagem e histórico.

### 3.3 Testes de regressão

Sempre que uma regra de produto ou estoque for alterada, todos os testes automatizados deverão ser executados novamente. Antes de uma entrega web, os cenários manuais de prioridade alta também deverão ser repetidos.

## 4. Ambiente de testes

- Java: JDK 17 ou superior;
- IDE: Apache NetBeans;
- Build: Maven;
- Framework de teste: JUnit Jupiter 6.1.2;
- Executor Maven: Surefire 3.5.4;
- Persistência dos testes: repositórios em memória;
- Versionamento: Git/GitHub;
- Comando principal: `mvn clean test`.

## 5. Critérios de entrada

Os testes podem começar quando:

1. o projeto compilar com Java 17;
2. as dependências Maven forem resolvidas;
3. as classes de domínio e serviços estiverem disponíveis;
4. os repositórios em memória estiverem funcionais;
5. o código sob teste estiver versionado.

## 6. Critérios de saída

A rodada de testes é considerada satisfatória quando:

1. todos os testes JUnit executarem sem falhas;
2. nenhum cenário de prioridade alta permanecer com defeito aberto;
3. os cálculos monetários apresentarem resultado exato em `BigDecimal`;
4. as regras de saldo, duplicidade e exclusão forem preservadas;
5. a evidência da execução e do versionamento estiver disponível para a entrega.

## 7. Casos de teste

| ID | Requisito | Tipo | Prioridade | Pré-condição | Passos / dados | Resultado esperado |
|---|---|---|---|---|---|---|
| CT01 | RF01/RN01 | Unitário/Manual | Alta | Repositório vazio | Cadastrar SKU `tec-001`, nome `Teclado`, preço `250,00` | Produto criado com SKU `TEC-001` |
| CT02 | RF02/RN01 | Unitário/Manual | Alta | `TEC-001` já cadastrado | Tentar cadastrar `tec-001` novamente | Operação rejeitada por duplicidade |
| CT03 | RN01 | Unitário/Manual | Alta | Nenhuma | Cadastrar SKU vazio ou somente espaços | Operação rejeitada; SKU obrigatório |
| CT04 | RN02 | Unitário/Manual | Alta | Nenhuma | Cadastrar nome vazio | Operação rejeitada; nome obrigatório |
| CT05 | RF01/RN03 | Unitário/Manual | Alta | Nenhuma | Cadastrar produto com preço zero | Operação rejeitada |
| CT06 | RF01/RN03 | Unitário/Manual | Alta | Nenhuma | Cadastrar produto com preço negativo | Operação rejeitada |
| CT07 | RF03 | Manual | Média | Produto cadastrado | Consultar `TEC-001` | Produto correto retornado |
| CT08 | RF03 | Manual | Média | SKU inexistente | Consultar `XXX-999` | Erro de produto não encontrado |
| CT09 | RF04 | Manual | Média | Dois ou mais produtos cadastrados | Listar produtos | Todos os produtos aparecem |
| CT10 | RF05 | Unitário/Manual | Média | Produto cadastrado | Alterar preço para `300,00` | Novo preço armazenado |
| CT11 | RF05/RN03 | Unitário/Manual | Alta | Produto cadastrado | Alterar preço para zero | Operação rejeitada |
| CT12 | RF06/RN04 | Unitário/Manual | Alta | Produto com saldo 0 | Registrar entrada de 10 | Saldo passa para 10 e movimentação é registrada |
| CT13 | RF06/RN04 | Unitário/Manual | Alta | Produto cadastrado | Registrar entrada 0 | Operação rejeitada |
| CT14 | RF07/RN04 | Unitário/Manual | Alta | Saldo 10 | Registrar saída de 3 | Saldo passa para 7 e movimentação é registrada |
| CT15 | RF07/RN04 | Unitário/Manual | Alta | Saldo 10 | Registrar saída 0 | Operação rejeitada |
| CT16 | RF08/RN05 | Unitário/Manual | Crítica | Saldo 7 | Tentar saída de 8 ou 100 | Operação rejeitada e saldo continua 7 |
| CT17 | RF09/RN07 | Unitário/Manual | Alta | Uma entrada e uma saída válidas | Consultar histórico | Duas movimentações exibidas |
| CT18 | RF09 | Manual | Média | Movimentações de SKUs distintos | Filtrar histórico por `TEC-001` | Apenas movimentações do SKU informado |
| CT19 | RF10/RN08 | Unitário/Manual | Alta | Produto a R$ 250,00 com 7 unidades | Calcular valor em estoque | Resultado `R$ 1.750,00` |
| CT20 | RF10/RN08 | Unitário/Manual | Alta | `TEC-001`: 7×250; `MOU-001`: 2×100 | Calcular total | Resultado `R$ 1.950,00` |
| CT21 | RF11/RN06 | Manual | Alta | Produto com saldo maior que zero | Tentar excluir | Exclusão rejeitada |
| CT22 | RF11/RN06 | Manual | Alta | Produto com saldo zero | Excluir produto | Produto removido com sucesso |
| CT23 | Web planejado | Manual | Alta | Interface web disponível | Preencher formulário com dados válidos e salvar | Confirmação exibida e produto aparece na listagem |
| CT24 | Web planejado | Manual | Alta | Interface web disponível | Enviar formulário com campos inválidos | Mensagens claras de validação; dados inválidos não persistem |
| CT25 | Web planejado | Manual | Alta | Produto com saldo conhecido | Registrar entrada/saída pela interface | Saldo visual é atualizado e histórico reflete a operação |
| CT26 | Web planejado | Manual | Média | Vários produtos | Navegar entre cadastro, listagem, detalhe e histórico | Navegação funciona sem perda indevida de dados |
| CT27 | Web/API planejada | Manual/Integração | Média | Endpoint disponível | Requisitar produto existente | Resposta de sucesso com dados corretos |
| CT28 | Web/API planejada | Manual/Integração | Alta | Endpoint disponível | Enviar operação que viola regra de negócio | Resposta de erro adequada; regra do domínio preservada |

## 8. Rastreabilidade dos testes JUnit implementados

| Classe de teste | Método | Regras/Requisitos relacionados |
|---|---|---|
| `ProdutoTest` | `deveCalcularValorEmEstoque` | RF10, RN08 |
| `ProdutoTest` | `deveAdicionarEstoque` | RF06, RN04 |
| `ProdutoTest` | `deveRejeitarEntradaComQuantidadeZero` | RN04 |
| `ProdutoTest` | `deveImpedirSaidaSuperiorAoEstoque` | RF08, RN05 |
| `ProdutoServiceTest` | `deveNormalizarSkuNoCadastro` | RF01, RN01 |
| `ProdutoServiceTest` | `deveRejeitarSkuDuplicado` | RF02, RN01 |
| `ProdutoServiceTest` | `deveRejeitarPrecoZero` | RF01, RN03 |
| `EstoqueServiceTest` | `deveRegistrarEntradaESaida` | RF06, RF07, RF09, RN07 |
| `EstoqueServiceTest` | `deveCalcularValorTotalDoEstoque` | RF10, RN08 |

## 9. Evidências esperadas

Para a entrega, devem ser preservadas as seguintes evidências:

- resultado dos testes no painel **Test Results** do NetBeans ou saída de `mvn clean test`;
- arquivos de teste dentro de `src/test/java`;
- histórico de commits da branch da Etapa 7;
- Pull Request da Etapa 7 no repositório da etapa anterior;
- documento de plano de testes em DOCX ou PDF;
- arquivo compactado contendo o projeto Maven/NetBeans com os testes.

## 10. Riscos e observações

- Os repositórios em memória tornam os testes rápidos e independentes de banco, mas não substituem futuros testes de integração com JDBC/JPA.
- Testes unitários não validam HTML, CSS, navegação ou comportamento do navegador; por isso há cenários manuais planejados para a etapa web.
- Valores monetários devem continuar usando `BigDecimal`, evitando regressões por arredondamento binário de `double`.
- Regras de negócio devem permanecer nos serviços e entidades; a futura camada web não deve duplicar essas validações.

## 11. Conclusão

O plano cobre as regras já implementadas e cria uma base de regressão para a futura aplicação web. A Etapa 7 adiciona testes JUnit reais ao núcleo reutilizável criado na Etapa 6, preservando a separação de responsabilidades e permitindo que mudanças futuras na interface ou persistência sejam verificadas sem reescrever as regras centrais.
