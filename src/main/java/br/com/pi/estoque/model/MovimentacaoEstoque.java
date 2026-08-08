package br.com.pi.estoque.model;

import java.time.LocalDateTime;

public record MovimentacaoEstoque(
        String sku,
        TipoMovimentacao tipo,
        int quantidade,
        LocalDateTime dataHora) {
}
