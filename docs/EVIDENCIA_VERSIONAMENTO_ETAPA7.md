# EVIDÊNCIA DE VERSIONAMENTO E EXECUÇÃO — PI ETAPA 7

## Identificação

- **Projeto:** Sistema de Controle de Estoque
- **Repositório:** `eleisonkyrie24-bit/pi-etapa6-controle-estoque`
- **Branch da Etapa 7:** `etapa7-junit`
- **Branch de destino:** `main`
- **Pull Request:** #1 — `PI Etapa 7: adiciona testes JUnit e plano de testes`
- **URL do PR:** https://github.com/eleisonkyrie24-bit/pi-etapa6-controle-estoque/pull/1

## Commits representativos da Etapa 7

| Commit | Mensagem | Evidência |
|---|---|---|
| `e9f7b264` | `test: configura JUnit para etapa 7` | JUnit Jupiter e Maven Surefire adicionados ao `pom.xml` |
| `6a321351` | `test: adiciona testes unitarios de Produto` | Testes do cálculo e invariantes locais de estoque |
| `24546bea` | `test: cobre cadastro e validacao de produto` | Testes de normalização, duplicidade e preço |
| `098e3201` | `test: cobre movimentacoes e valor total do estoque` | Testes de entrada/saída, histórico e cálculo total |
| `974589c7` | `ci: executa testes JUnit no GitHub Actions` | Workflow automatizado com Java 17 e Maven |
| `b9a3c11c` | `docs: adiciona plano de testes da etapa 7` | Plano de testes versionado junto ao projeto |

## Testes JUnit versionados

Foram adicionadas três classes em `src/test/java`:

1. `br.com.pi.estoque.model.ProdutoTest` — 4 testes;
2. `br.com.pi.estoque.service.ProdutoServiceTest` — 3 testes;
3. `br.com.pi.estoque.service.EstoqueServiceTest` — 2 testes.

**Total: 9 testes JUnit.**

## Evidência de execução automatizada

Foi configurado o workflow `.github/workflows/testes-junit.yml`, executado no GitHub Actions com:

- ambiente: `ubuntu-latest`;
- Java: Temurin 17;
- comando: `mvn --batch-mode clean test`;
- workflow: `Testes JUnit - PI Etapa 7`;
- execução: **#4**;
- run ID: `31270478168`;
- job ID: `93135420702`;
- commit validado: `b9a3c11c82b4731f228adaf8a321800e2f943d77`;
- resultado final: **SUCCESS**;
- etapa `Executar testes unitários`: **SUCCESS**.

URL da execução:
https://github.com/eleisonkyrie24-bit/pi-etapa6-controle-estoque/actions/runs/31270478168

## Conclusão da evidência

A Etapa 7 está efetivamente versionada no mesmo repositório utilizado na Etapa 6. O histórico da branch registra separadamente configuração, testes e documentação; o Pull Request #1 permite comparar a Etapa 7 com a `main`; e o GitHub Actions comprova que o projeto de testes foi compilado e executado com sucesso em Java 17 por meio do Maven.
