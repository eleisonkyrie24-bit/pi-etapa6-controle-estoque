# PLANO DE TESTES — PI ETAPA 7

## Sistema de Controle de Estoque

**Aluno:** Matheus França Lopes Martins  
**Curso:** Projeto Integrador Assistente de Desenvolvimento de Sistemas II  
**Unidade Curricular:** UC15  
**Professor:** Lucas Fraga  
**Ano:** 2026

## 1. Objetivo

Este plano define os testes básicos do Sistema de Controle de Estoque desenvolvido nas etapas anteriores. O objetivo da Etapa 7 é verificar as principais regras de negócio já implementadas, reduzir regressões e registrar evidências reproduzíveis da execução dos testes e do versionamento.

A interface Web e a persistência com JDBC/JPA pertencem às etapas posteriores do Projeto Integrador e **não são critérios de conclusão da Etapa 7**.

## 2. Escopo da Etapa 7

Estão incluídos:

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
- testes JUnit da camada de domínio e serviços;
- evidências de execução no NetBeans e de versionamento no GitHub.

Não fazem parte do critério de saída desta etapa: interface HTML/CSS/JavaScript, endpoints Web/REST, autenticação, autorização, integração com fornecedores ou banco de dados persistente. Cenários para essas funcionalidades são registrados apenas na seção **Testes previstos para etapas posteriores**.

## 3. Organização do projeto de testes no NetBeans

Foi adotada a estrutura Maven convencional, reconhecida pelo Apache NetBeans:

- `src/main/java`: código de produção;
- `src/test/java`: código de testes JUnit;
- `pom.xml`: dependências e configuração de build/teste.

Essa organização mantém produção e testes separados no mesmo projeto Maven, permite execução pelo NetBeans e por `mvn clean test` e evita duplicação das classes de domínio em um projeto paralelo.

## 4. Estratégia de testes

### 4.1 Testes unitários automatizados

Os testes utilizam JUnit Jupiter e Maven Surefire. Cada teste cria seus próprios objetos e, quando necessário, repositórios em memória.

Classes implementadas:

- `ProdutoTest`: 4 testes;
- `ProdutoServiceTest`: 3 testes;
- `EstoqueServiceTest`: 2 testes.

**Total automatizado: 9 testes JUnit.**

### 4.2 Testes manuais do núcleo

Os testes manuais complementam a suíte automatizada nos fluxos que não foram convertidos para JUnit nesta etapa, como consulta, listagem, alteração de preço, filtragem de histórico e exclusão condicionada ao saldo.

### 4.3 Regressão

Sempre que uma regra de produto ou estoque for alterada, a suíte JUnit deve ser executada novamente. Uma rodada da Etapa 7 é satisfatória somente quando os testes automatizados terminam sem falhas e nenhuma regra crítica conhecida permanece quebrada.

## 5. Ambiente de testes

- Java: JDK 17;
- IDE: Apache NetBeans;
- Build: Maven;
- Framework de teste: JUnit Jupiter 6.1.2;
- Maven Surefire Plugin: 3.5.4;
- Persistência utilizada nos testes: repositórios em memória;
- Versionamento: Git/GitHub;
- Comando de execução: `mvn clean test`.

## 6. Critérios de entrada

1. Projeto compila com Java 17.
2. Dependências Maven são resolvidas.
3. Classes de domínio e serviços estão disponíveis.
4. Repositórios em memória estão funcionais.
5. Código sob teste está versionado.

## 7. Critérios de saída

1. Todos os testes JUnit executam sem falhas.
2. Nenhuma regra de prioridade Alta ou Crítica fica com defeito conhecido não tratado.
3. Cálculos monetários permanecem exatos com `BigDecimal`.
4. Regras de saldo, duplicidade e exclusão permanecem preservadas.
5. Evidências da execução e do versionamento estão disponíveis.

A evidência local obtida no Apache NetBeans registrou: **Tests run: 9, Failures: 0, Errors: 0, Skipped: 0 — BUILD SUCCESS**.

## 8. Casos de teste da Etapa 7

| ID | Requisito | Tipo | Prioridade | Pré-condição | Passos / dados | Resultado esperado |
|---|---|---|---|---|---|---|
| CT01 | RF01/RN01 | Unitário/Manual | Alta | Repositório vazio | Cadastrar SKU `tec-001`, nome `Teclado`, preço `250,00` | Produto criado com SKU `TEC-001` |
| CT02 | RF02/RN01 | Unitário/Manual | Alta | `TEC-001` cadastrado | Cadastrar `tec-001` novamente | Operação rejeitada por duplicidade |
| CT03 | RN01 | Manual | Alta | Nenhuma | Cadastrar SKU vazio ou somente espaços | Operação rejeitada; SKU obrigatório |
| CT04 | RN02 | Manual | Alta | Nenhuma | Cadastrar nome vazio | Operação rejeitada; nome obrigatório |
| CT05 | RF01/RN03 | Unitário/Manual | Alta | Nenhuma | Cadastrar produto com preço zero | Operação rejeitada |
| CT06 | RF01/RN03 | Manual | Alta | Nenhuma | Cadastrar produto com preço negativo | Operação rejeitada |
| CT07 | RF03 | Manual | Média | Produto cadastrado | Consultar `TEC-001` | Produto correto retornado |
| CT08 | RF03 | Manual | Média | SKU inexistente | Consultar `XXX-999` | Erro de produto não encontrado |
| CT09 | RF04 | Manual | Média | Dois ou mais produtos | Listar produtos | Todos os produtos aparecem |
| CT10 | RF05 | Manual | Média | Produto cadastrado | Alterar preço para `300,00` | Novo preço armazenado |
| CT11 | RF05/RN03 | Manual | Alta | Produto cadastrado | Alterar preço para zero | Operação rejeitada |
| CT12 | RF06/RN04 | Unitário/Manual | Alta | Saldo 0 | Registrar entrada de 10 | Saldo passa para 10 e movimentação é registrada |
| CT13 | RF06/RN04 | Unitário/Manual | Alta | Produto cadastrado | Registrar entrada 0 | Operação rejeitada |
| CT14 | RF07/RN04 | Unitário/Manual | Alta | Saldo 10 | Registrar saída de 3 | Saldo passa para 7 e movimentação é registrada |
| CT15 | RF07/RN04 | Manual | Alta | Saldo 10 | Registrar saída 0 | Operação rejeitada |
| CT16 | RF08/RN05 | Unitário/Manual | Crítica | Saldo 7 | Tentar saída de 8 ou 100 | Operação rejeitada e saldo continua 7 |
| CT17 | RF09/RN07 | Unitário/Manual | Alta | Entrada e saída válidas | Consultar histórico | Duas movimentações exibidas |
| CT18 | RF09 | Manual | Média | Movimentações de SKUs distintos | Filtrar histórico por `TEC-001` | Apenas movimentações do SKU informado |
| CT19 | RF10/RN08 | Unitário/Manual | Alta | Produto a R$ 250,00 com 7 unidades | Calcular valor em estoque | Resultado `R$ 1.750,00` |
| CT20 | RF10/RN08 | Unitário/Manual | Alta | 7×250 e 2×100 | Calcular total | Resultado `R$ 1.950,00` |
| CT21 | RF11/RN06 | Manual | Alta | Produto com saldo > 0 | Tentar excluir | Exclusão rejeitada |
| CT22 | RF11/RN06 | Manual | Alta | Produto com saldo 0 | Excluir produto | Produto removido com sucesso |

**Total da Etapa 7: 22 casos planejados, dos quais 9 testes estão automatizados em JUnit.**

## 9. Rastreabilidade dos testes JUnit implementados

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

## 10. Evidências

As evidências estão versionadas em `docs/evidencias/`:

- `01_PR_MERGE.png` — registro visual do Pull Request #1 integrado à `main`;
- `02_COMMITS.png` — registro visual do histórico de commits da Etapa 7;
- `03_GITHUB_ACTIONS_SUCCESS.png` — registro visual da execução automatizada concluída com sucesso;
- `04_TESTES_NETBEANS.png` — **captura de tela real do Apache NetBeans**, mostrando `Tests run: 9, Failures: 0, Errors: 0, Skipped: 0` e `BUILD SUCCESS`.

## 11. Testes previstos para etapas posteriores — fora do critério da Etapa 7

Os cenários abaixo são mantidos apenas como planejamento para a continuidade Web. Eles **não são contados como casos executados ou exigidos para concluir a Etapa 7**.

| ID futuro | Camada | Cenário | Resultado esperado |
|---|---|---|---|
| FW01 | Web | Enviar formulário de cadastro válido | Confirmação exibida e produto listado |
| FW02 | Web | Enviar formulário com dados inválidos | Validação clara e dados não persistidos |
| FW03 | Web | Registrar entrada/saída pela interface | Saldo e histórico atualizados |
| FW04 | Web | Navegar entre cadastro, listagem, detalhe e histórico | Navegação consistente |
| FW05 | Web/REST | Consultar produto existente por endpoint | Resposta de sucesso com dados corretos |
| FW06 | Web/REST | Enviar operação que viola regra de negócio | Resposta de erro e regra do domínio preservada |

## 12. Riscos e observações

- Repositórios em memória tornam a suíte independente de banco; testes de integração JDBC/JPA serão necessários quando a persistência for implementada.
- Testes JUnit desta etapa validam domínio e serviços, não HTML, CSS ou navegador.
- Valores monetários devem continuar usando `BigDecimal`.
- Regras de negócio devem permanecer no domínio/serviços para serem reutilizadas nas etapas posteriores.

## 13. Conclusão

A Etapa 7 possui uma suíte JUnit executável no Apache NetBeans e no Maven, com nove testes automatizados aprovados, plano de testes do núcleo, evidência local de `BUILD SUCCESS` e histórico de versionamento no GitHub. Os cenários Web foram separados do escopo atual para evitar que funcionalidades ainda pertencentes às etapas posteriores sejam interpretadas como pendências desta entrega.
