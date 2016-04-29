package br.com.davividal.msport.Domain.Entities;

import java.io.Serializable;

import br.com.davividal.msport.Domain.ValueObjects.Preco;

public class Produto implements Serializable {
    private final String nome;
    private final String descricao;
    private final Double valor;
    private final Integer imagem;

    /**
     * @param nome      nome do produto
     * @param descricao descrição do produto
     * @param valor     preço do produto
     * @param imagem    ID da imagem do produto
     */
    public Produto(String nome, String descricao, Double valor, Integer imagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.imagem = imagem;
    }

    /**
     * @param quantidade quantidade de produtos que estão sendo solicitados
     * @return Double
     */
    public Double getSubTotal(Integer quantidade) {
        return valor * quantidade;
    }

    /**
     * @return String
     */
    public String getValor() {
        return (new Preco(this.valor)).toString();
    }

    /**
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return Integer
     */
    public Integer getImagem() {
        return imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean equals(Object outro) {
        return outro instanceof Produto && (
                (
                        (Produto) outro).getNome().equals(nome)
                        && ((Produto) outro).getDescricao().equals(descricao)
                        && ((Produto) outro).getImagem().equals(imagem)
                        && ((Produto) outro).getValor().equals(getValor())
        );
    }

    public int hashCode() {
        int hash = 1;
        hash = hash * 42 + nome.hashCode();
        hash = hash * 42 + descricao.hashCode();
        hash = hash * 42 + getValor().hashCode();
        return hash;
    }
}
