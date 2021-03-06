package br.com.davividal.msport.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

import br.com.davividal.msport.DetalhesProduto;
import br.com.davividal.msport.Domain.Entities.Produto;

public class ProductDetailListener implements AdapterView.OnItemClickListener {
    private final Activity parentActivity;
    private final ArrayList<Produto> produtos;

    /**
     * Design pattern: Injeção de Dependência (Dependency Injection)
     *
     * @param parentActivity Activity onde este listener estiver sendo usado
     * @param produtos
     */
    public ProductDetailListener(Activity parentActivity, ArrayList<Produto> produtos) {
        this.parentActivity = parentActivity;
        this.produtos = produtos;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Produto produto = this.produtos.get(position);
        Bundle params = new Bundle();
        params.putSerializable("produto", produto);

        Intent it = new Intent(parentActivity, DetalhesProduto.class);
        it.putExtras(params);
        parentActivity.startActivity(it);
    }
}
