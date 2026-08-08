package br.com.pi.estoque;

import br.com.pi.estoque.exception.RegraNegocioException;
import br.com.pi.estoque.model.Produto;
import br.com.pi.estoque.repository.MovimentacaoRepository;
import br.com.pi.estoque.repository.ProdutoRepository;
import br.com.pi.estoque.repository.memory.InMemoryMovimentacaoRepository;
import br.com.pi.estoque.repository.memory.InMemoryProdutoRepository;
import br.com.pi.estoque.service.EstoqueService;
import br.com.pi.estoque.service.ProdutoService;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        ProdutoRepository produtoRepository = new InMemoryProdutoRepository();
        MovimentacaoRepository movimentacaoRepository = new InMemoryMovimentacaoRepository();

        ProdutoService produtoService = new ProdutoService(produtoRepository);
        EstoqueService estoqueService = new EstoqueService(produtoRepository, movimentacaoRepository);

        System.out.println("=== TESTES FUNCIONAIS - PI ETAPA 6 ===");

        Produto teclado = produtoService.cadastrar(
                "tec-001", "Teclado Mecânico", new BigDecimal("250.00"));
        verificar("SKU é normalizado", "TEC-001".equals(teclado.getSku()));

        estoqueService.registrarEntrada(teclado, 10);
        verificar("Entrada soma ao estoque", teclado.getQuantidadeEmEstoque() == 10);

        estoqueService.registrarSaida(teclado, 3);
        verificar("Saída reduz o estoque", teclado.getQuantidadeEmEstoque() == 7);

        verificar("Movimentações ficam registradas", estoqueService.listarHistorico().size() == 2);
        verificar("Valor do estoque é calculado",
                estoqueService.calcularValorTotalEstoque().compareTo(new BigDecimal("1750.00")) == 0);

        esperarErro("SKU duplicado é rejeitado", () ->
                produtoService.cadastrar("TEC-001", "Outro teclado", new BigDecimal("100.00")));

        esperarErro("Saída maior que o estoque é rejeitada", () ->
                estoqueService.registrarSaida(teclado, 100));

        esperarErro("Produto com saldo não pode ser removido", () ->
                produtoService.remover("TEC-001"));

        estoqueService.registrarSaida(teclado, 7);
        produtoService.remover("TEC-001");
        verificar("Produto zerado pode ser removido", produtoService.listarTodos().isEmpty());

        System.out.println("\nTodos os testes foram concluídos com sucesso.");
    }

    private static void verificar(String descricao, boolean condicao) {
        if (!condicao) {
            throw new AssertionError("FALHA: " + descricao);
        }
        System.out.println("[OK] " + descricao);
    }

    private static void esperarErro(String descricao, Runnable acao) {
        try {
            acao.run();
            throw new AssertionError("FALHA: " + descricao + " - exceção esperada não ocorreu.");
        } catch (RegraNegocioException ex) {
            System.out.println("[OK] " + descricao + " -> " + ex.getMessage());
        }
    }
}
