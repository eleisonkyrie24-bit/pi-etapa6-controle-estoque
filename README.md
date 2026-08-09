# PI — Sistema de Controle de Estoque

Projeto Java desenvolvido no Projeto Integrador. O repositório surgiu na Etapa 6, quando o núcleo foi separado em domínio, serviços e repositórios, e foi ampliado na Etapa 7 com testes automatizados JUnit, plano de testes e evidências de execução.

## Tecnologias

- Java 17
- Maven
- Apache NetBeans
- JUnit Jupiter
- Maven Surefire Plugin
- Git/GitHub
- GitHub Actions

## Estrutura

- `src/main/java`: código de produção;
- `src/test/java`: testes JUnit;
- `model`: entidades e tipos do domínio;
- `repository`: contratos de persistência;
- `repository.memory`: implementações em memória usadas nesta etapa;
- `service`: regras de negócio e casos de uso;
- `exception`: exceções de domínio;
- `docs`: arquitetura, plano de testes e evidências.

A separação `src/main/java` e `src/test/java` é a estrutura Maven convencional e é reconhecida diretamente pelo Apache NetBeans, mantendo produção e testes no mesmo projeto sem misturar responsabilidades.

## Executar no NetBeans

1. Abra o Apache NetBeans.
2. Use **File > Open Project** e selecione a pasta do repositório.
3. Aguarde a resolução das dependências Maven.
4. Para a aplicação, execute `br.com.pi.estoque.Main` ou **Run Project**.
5. Para a Etapa 7, use **Test Project / Test**.

## Executar os testes por terminal

```bash
mvn clean test
```

A suíte da Etapa 7 possui **9 testes JUnit**. A execução local registrada no NetBeans apresentou:

`Tests run: 9, Failures: 0, Errors: 0, Skipped: 0` — `BUILD SUCCESS`.

## Regras implementadas

- SKU obrigatório, normalizado e único.
- Nome obrigatório.
- Preço maior que zero.
- Quantidades de entrada e saída positivas.
- Saída não pode deixar estoque negativo.
- Produto com saldo em estoque não pode ser excluído.
- Toda movimentação válida é registrada em histórico.
- Valor total do estoque é calculado pela soma de `preço × quantidade`.

## Etapa 7 — documentação e evidências

- Plano de testes: `docs/PLANO_TESTES_ETAPA7.md`
- Evidência de versionamento: `docs/EVIDENCIA_VERSIONAMENTO_ETAPA7.md`
- Prints/evidências: `docs/evidencias/`
- Workflow: `.github/workflows/testes-junit.yml`

O Pull Request #1 da Etapa 7 foi integrado à branch `main` após execução bem-sucedida do workflow de testes.

## Continuidade do projeto

A interface Web e a persistência JDBC/JPA pertencem às etapas posteriores. Elas não são tratadas como pendências da Etapa 7; os cenários Web permanecem apenas como planejamento futuro no plano de testes.

## Repositório

`https://github.com/eleisonkyrie24-bit/pi-etapa6-controle-estoque`

Branch principal: `main`.
