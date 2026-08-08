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

## Commits representativos da Etapa 7

| Commit | Mensagem | Evidência |
|---|---|---|
| `e9f7b264` | `test: configura JUnit para etapa 7` | JUnit Jupiter e Maven Surefire no `pom.xml` |
| `6a321351` | `test: adiciona testes unitarios de Produto` | Cálculo e invariantes locais de estoque |
| `24546bea` | `test: cobre cadastro e validacao de produto` | Normalização, duplicidade e preço |
| `098e3201` | `test: cobre movimentacoes e valor total do estoque` | Entrada/saída, histórico e cálculo total |
| `974589c7` | `ci: executa testes JUnit no GitHub Actions` | Workflow com Java 17 e Maven |
| `b9a3c11c` | `docs: adiciona plano de testes da etapa 7` | Plano básico de testes versionado |
| `aa7b97e1` | `docs: registra evidencia de versionamento e testes` | Evidência da Etapa 7 |

## Testes JUnit versionados

Foram adicionadas três classes em `src/test/java`:

1. `br.com.pi.estoque.model.ProdutoTest` — 4 testes;
2. `br.com.pi.estoque.service.ProdutoServiceTest` — 3 testes;
3. `br.com.pi.estoque.service.EstoqueServiceTest` — 2 testes.

**Total: 9 testes JUnit.**

## GitHub Actions — validação do HEAD final da branch

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

## Validação local complementar

O núcleo Java também foi compilado com `javac --release 17` e o método `Main` concluiu os cenários funcionais herdados da Etapa 6 sem falhas.

## Conclusão

O projeto de testes foi versionado no repositório da Etapa 6, validado por CI e integrado à branch `main` pelo Pull Request #1. A branch `etapa7-junit` permanece como histórico de desenvolvimento e a `main` contém a versão consolidada da Etapa 7.
