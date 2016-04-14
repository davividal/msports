package br.com.davividal.msport.Domain.Entities;

import br.com.davividal.msport.Domain.ValueObjects.Preco;

public class Produto {
    private String nome;
    private String descricao;
    private Double valor;
    private Integer imagem;

    /**
     * @param nome      nome do produto
     * @param descricao descição do produto
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
     * @param nome nome do produto
     */
    public Produto(String nome) {
        this.nome = nome;
    }

    /**
     * @param descricao descrição do produto
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
     * @param valor preço do produto
     */
    public void setValor(Double valor) {
        this.valor = valor;
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

    /**
     * @param imagem ID da imagem do produto
     */
    public void setImagem(Integer imagem) {
        this.imagem = imagem;
    }
}
