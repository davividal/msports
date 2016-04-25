package br.com.davividal.msport.Domain.ValueObjects;

import java.util.Locale;

public class Preco {
    private final Double valor;

    public Preco(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format(new Locale("pt", "br"), "R$ %.2f", this.valor);
    }
}
