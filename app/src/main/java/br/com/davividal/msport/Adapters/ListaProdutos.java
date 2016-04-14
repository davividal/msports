package br.com.davividal.msport.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import br.com.davividal.msport.Domain.Entities.Produto;
import br.com.davividal.msport.R;

public class ListaProdutos extends ArrayAdapter<Produto> {
    private Activity context;
    private Produto[] produtos;

    public ListaProdutos(Activity context, Produto[] produtos) {
        super(context, R.layout.list_cell, produtos);
        this.context = context;
        this.produtos = produtos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AtomicReference<ViewGroup> rootGroup = new AtomicReference<>(null);
        AtomicBoolean attachToRoot = new AtomicBoolean(true);

        ProdutoViewHolder produtoViewHolder;

        if (null == convertView) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_cell, parent, false);

            produtoViewHolder = new ProdutoViewHolder();
            produtoViewHolder.nome = (TextView) convertView.findViewById(R.id.product_name);
            produtoViewHolder.preco = (TextView) convertView.findViewById(R.id.product_price);
            produtoViewHolder.imagem = (ImageView) convertView.findViewById(R.id.product_image);

            convertView.setTag(produtoViewHolder);
        } else {
            produtoViewHolder = (ProdutoViewHolder) convertView.getTag();
        }

        Produto produto = produtos[position];
        if (null != produto) {
            produtoViewHolder.nome.setText(produto.getNome());
            produtoViewHolder.preco.setText(produto.getValor());
            produtoViewHolder.imagem.setImageResource(produto.getImagem());
        }

        return convertView;
    }

    static class ProdutoViewHolder {
        TextView nome;
        TextView preco;
        ImageView imagem;
        int position;
    }
}
