package br.com.davividal.msport.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import br.com.davividal.msport.Domain.Aggregates.Compras;
import br.com.davividal.msport.Domain.Entities.Produto;
import br.com.davividal.msport.R;

public class RelatorioCompras extends ArrayAdapter<Produto> {
    private final Activity context;
    private final ArrayList<Produto> produtos;

    public RelatorioCompras(Activity context, ArrayList<Produto> produtos) {
        super(context, R.layout.list_bought_products, produtos);
        this.context = context;
        this.produtos = produtos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProdutoViewHolder produtoViewHolder;

        if (null == convertView) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_bought_products, parent, false);

            produtoViewHolder = new ProdutoViewHolder();
            produtoViewHolder.nome = (TextView) convertView.findViewById(R.id.product_name);
            produtoViewHolder.quantidade = (TextView) convertView.findViewById(R.id.product_quantity);
            produtoViewHolder.preco = (TextView) convertView.findViewById(R.id.product_price);
            produtoViewHolder.imagem = (ImageView) convertView.findViewById(R.id.product_image);

            convertView.setTag(produtoViewHolder);
        } else {
            produtoViewHolder = (ProdutoViewHolder) convertView.getTag();
        }

        Produto produto = produtos.get(position);
        if (null != produto) {
            Integer quantidade = Compras.getInstance().getProdutoQuantidade(produto);

            produtoViewHolder.nome.setText(produto.getNome());
            produtoViewHolder.quantidade.setText(
                    String.format(new Locale("pt", "br"), "Quantidade: %d", quantidade)
            );
            produtoViewHolder.preco.setText(produto.getValor());
            produtoViewHolder.imagem.setImageResource(produto.getImagem());
        }

        return convertView;
    }

    static class ProdutoViewHolder {
        TextView nome;
        TextView quantidade;
        TextView preco;
        ImageView imagem;
    }
}
