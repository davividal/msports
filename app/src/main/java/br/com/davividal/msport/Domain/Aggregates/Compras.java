package br.com.davividal.msport.Domain.Aggregates;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import br.com.davividal.msport.Domain.Entities.Produto;
import br.com.davividal.msport.Domain.ValueObjects.Preco;

public class Compras {
    private static Compras instance = null;

    private final Hashtable<Produto, Integer> carrinho;

    /**
     * Design pattern: Singleton
     */
    private Compras() {
        carrinho = new Hashtable<>();
    }

    /**
     * @return Compras
     */
    public static Compras getInstance() {
        if (null == instance) {
            instance = new Compras();
        }

        return instance;
    }

    /**
     * @param produto Produto
     */
    public void addProduto(Produto produto) {
        Integer quantidade = 1;

        if (carrinho.containsKey(produto)) {
            quantidade = carrinho.get(produto) + 1;
        }

        carrinho.put(produto, quantidade);
    }

    /**
     * @return String
     */
    public String getTotal() {
        Double total = 0d;

        for (Map.Entry<Produto, Integer> entry : carrinho.entrySet()) {
            total += entry.getKey().getSubTotal(entry.getValue());
        }

        return (new Preco(total)).toString();
    }

    /**
     * @return ArrayList
     */
    public ArrayList<Produto> getProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();

        for (Map.Entry<Produto, Integer> entry : carrinho.entrySet()) {
            produtos.add(entry.getKey());
        }

        return produtos;
    }

    /**
     * @param produto Produto para pegar a quantidade de vendas
     * @return Integer
     */
    public Integer getProdutoQuantidade(Produto produto) {
        return carrinho.get(produto);
    }
}
