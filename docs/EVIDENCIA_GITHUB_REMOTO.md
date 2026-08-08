# Evidência do repositório GitHub remoto

Verificação realizada em **08/08/2026** por meio da integração autenticada com o GitHub.

## Repositório

- Conta: `eleisonkyrie24-bit`
- Repositório: `pi-etapa6-controle-estoque`
- URL: `https://github.com/eleisonkyrie24-bit/pi-etapa6-controle-estoque`
- Visibilidade: **público**
- Branch padrão: `main`
- Permissão da conta conectada: `admin` / `push`

## Estrutura confirmada na branch main

Na raiz foram confirmados diretamente no GitHub:

- `.gitignore`
- `INSTRUCOES_GITHUB.md`
- `README.md`
- `docs/`
- `nbactions.xml`
- `pom.xml`
- `src/`

## Commits remotos representativos

- `007ea45` — `docs: atualiza README com repositório remoto publicado`
- `3c5a7bf` — `docs: registra endereço do repositório remoto`
- `f34a5ae` — `docs: registra code smells e refatorações`
- `b5461c6` — `test: adiciona testes funcionais no main`
- `93760f6` — `refactor: separa regras de produto em ProdutoService`
- `4b58cdc` — `refactor: separa regras de movimentação em EstoqueService`
- `3615efd` — `docs: adiciona baseline monolítica para comparação`

## Classe refatorada confirmada no remoto

Arquivo:

`src/main/java/br/com/pi/estoque/service/ProdutoService.java`

Blob SHA verificado:

`93994036ec627bf6f859c9d761004ec9ff54c308`

URL:

`https://github.com/eleisonkyrie24-bit/pi-etapa6-controle-estoque/blob/main/src/main/java/br/com/pi/estoque/service/ProdutoService.java`

A classe foi lida diretamente do GitHub e contém a dependência por `ProdutoRepository`, evidenciando a separação entre regra de negócio e persistência concreta.

## Validação local do mesmo código

O código foi compilado com:

```text
javac --release 17
```

Em seguida, `br.com.pi.estoque.Main` foi executado. Os nove cenários funcionais previstos no relatório foram concluídos com sucesso.
