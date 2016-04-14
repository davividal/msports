package br.com.davividal.msport.Domain.Aggregates;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import br.com.davividal.msport.Domain.Entities.Produto;
import br.com.davividal.msport.Domain.ValueObjects.Preco;

public class Compras {
    private static Compras instance = null;

    private Hashtable<Produto, Integer> carrinho;

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

        Map<Produto, Integer> map;
        map = new HashMap<>();

        for (Map.Entry<Produto, Integer> entry : map.entrySet()) {
            total += entry.getKey().getSubTotal(entry.getValue());
        }

        return (new Preco(total)).toString();
    }
}
