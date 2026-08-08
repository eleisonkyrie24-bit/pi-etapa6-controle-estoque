# PI - Etapa 6: Sistema de Controle de Estoque

Projeto Java desenvolvido para a Etapa 6 do Projeto Integrador, considerando a alternativa prevista no enunciado para alunos que não realizaram as etapas anteriores.

## Objetivo

Demonstrar a separação entre regras de negócio e camada de apresentação, preparando o núcleo da aplicação para reutilização em uma futura aplicação web.

## Tecnologias

- Java 17
- Maven
- Apache NetBeans (projeto Maven reconhecido pelo IDE)
- Git/GitHub

## Arquitetura

- `model`: entidades e tipos do domínio.
- `repository`: contratos de persistência.
- `repository.memory`: implementação em memória usada nos testes.
- `service`: regras de negócio e casos de uso.
- `exception`: exceções de domínio.
- `Main`: composição das dependências e testes funcionais solicitados no enunciado.

## Executar no NetBeans

1. Abra o Apache NetBeans.
2. Acesse **File > Open Project** e selecione esta pasta.
3. Aguarde o carregamento do Maven.
4. Execute `br.com.pi.estoque.Main` ou use **Run Project**.

## Executar por terminal

Com Maven instalado:

```bash
mvn clean compile exec:java
```

Também é possível compilar com `javac` usando JDK 17 ou superior.

## Regras implementadas

- SKU obrigatório e único.
- Nome obrigatório.
- Preço maior que zero.
- Quantidades de entrada e saída devem ser positivas.
- Saída não pode deixar estoque negativo.
- Produto com saldo em estoque não pode ser excluído.
- Toda movimentação válida é registrada em histórico.
- Valor total do estoque é calculado pela soma de `preço x quantidade`.

## Padrão de projeto

Foi utilizado o padrão **Repository**, isolando a regra de negócio da tecnologia de armazenamento. `ProdutoService` e `EstoqueService` dependem de interfaces, não de `HashMap`, banco de dados ou componentes Swing.

## Evidências de refatoração

A pasta `docs/versao-inicial` contém um protótipo monolítico, criado apenas como baseline desta etapa. Ele demonstra os problemas que foram removidos na arquitetura final.

## GitHub

Após criar o repositório remoto, substitua o campo indicado no relatório pelo endereço real e insira as capturas de tela solicitadas. O arquivo `INSTRUCOES_GITHUB.md` contém os comandos.
