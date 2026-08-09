# EVIDÊNCIA DE VERSIONAMENTO E EXECUÇÃO — PI ETAPA 7

## Repositório e integração

- **Projeto:** Sistema de Controle de Estoque
- **Repositório:** `eleisonkyrie24-bit/pi-etapa6-controle-estoque`
- **Branch de desenvolvimento/testes:** `etapa7-junit`
- **Branch integrada:** `main`
- **Pull Request:** #1 — `PI Etapa 7: adiciona testes JUnit e plano de testes`
- **URL do PR:** https://github.com/eleisonkyrie24-bit/pi-etapa6-controle-estoque/pull/1
- **Situação final do PR:** MERGED
- **Commit de merge:** `b6392d299d6ebff587f9d76268fd84179bdc6a4a`
- **Data/hora do merge no GitHub:** 2026-08-08T18:00:18Z

## Estrutura das evidências

Os arquivos de evidência estão versionados em:

`docs/evidencias/`

- `01_PR_MERGE.png` — registro visual do Pull Request #1 e integração da branch `etapa7-junit` na `main`;
- `02_COMMITS.png` — registro visual do histórico de commits da Etapa 7;
- `03_GITHUB_ACTIONS_SUCCESS.png` — registro visual da execução automatizada no GitHub Actions;
- `04_TESTES_NETBEANS.png` — **captura de tela real do Apache NetBeans** com a execução local dos testes.

## Execução local no Apache NetBeans

A captura `04_TESTES_NETBEANS.png` registra a execução real do projeto no Apache NetBeans IDE 30. O painel de saída apresenta:

- **Tests run:** 9
- **Failures:** 0
- **Errors:** 0
- **Skipped:** 0
- **Resultado:** `BUILD SUCCESS`

Essa captura comprova que a suíte JUnit foi reconhecida e executada pelo projeto Maven aberto no NetBeans.

## Testes JUnit versionados

Foram implementadas três classes em `src/test/java`:

1. `br.com.pi.estoque.model.ProdutoTest` — 4 testes;
2. `br.com.pi.estoque.service.ProdutoServiceTest` — 3 testes;
3. `br.com.pi.estoque.service.EstoqueServiceTest` — 2 testes.

**Total: 9 testes JUnit.**

A organização `src/main/java` + `src/test/java` segue o padrão Maven e mantém código de produção e código de teste separados dentro do mesmo projeto reconhecido pelo Apache NetBeans.

## Commits representativos da Etapa 7

| Commit | Mensagem | Evidência |
|---|---|---|
| `e9f7b264` | `test: configura JUnit para etapa 7` | JUnit Jupiter e Maven Surefire no `pom.xml` |
| `6a321351` | `test: adiciona testes unitarios de Produto` | Cálculo e invariantes locais de estoque |
| `24546bea` | `test: cobre cadastro e validacao de produto` | Normalização, duplicidade e preço |
| `098e3201` | `test: cobre movimentacoes e valor total do estoque` | Entrada/saída, histórico e cálculo total |
| `974589c7` | `ci: executa testes JUnit no GitHub Actions` | Workflow com Java 17 e Maven |
| `b9a3c11c` | `docs: adiciona plano de testes da etapa 7` | Plano de testes versionado |
| `aa7b97e1` | `docs: registra evidencia de versionamento e testes` | Registro documental da Etapa 7 |
| `f1982450` | `docs: organiza prints de evidencia da etapa 7` | Evidências movidas para `docs/evidencias/` |

## GitHub Actions

- workflow: `Testes JUnit - PI Etapa 7`;
- execução: **#6**;
- run ID: `31270536720`;
- commit validado: `aa7b97e12d8c187378a7368f19ca9b25b5340286`;
- ambiente: `ubuntu-latest`;
- Java: Temurin 17;
- comando: `mvn --batch-mode clean test`;
- resultado: **SUCCESS**.

URL da execução:
https://github.com/eleisonkyrie24-bit/pi-etapa6-controle-estoque/actions/runs/31270536720

## Escopo da Etapa 7

A Etapa 7 valida o núcleo Java já implementado. A interface Web e a persistência JDBC/JPA são continuidade do Projeto Integrador e não são tratadas como pendências desta etapa. Cenários Web permanecem no plano apenas como testes futuros, separados dos 22 casos pertencentes ao escopo atual.

## Conclusão

O projeto de testes está versionado, a suíte JUnit possui nove testes aprovados localmente no NetBeans e também foi validada por CI. O Pull Request #1 foi integrado à `main` e as evidências estão organizadas em `docs/evidencias/` para consulta e entrega.
