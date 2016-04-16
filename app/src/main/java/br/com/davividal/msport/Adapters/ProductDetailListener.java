package br.com.davividal.msport.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import br.com.davividal.msport.DetalhesProduto;

public class ProductDetailListener implements AdapterView.OnItemClickListener {
    private Activity parentActivity;

    /**
     * Design pattern: Injeção de Dependência (Dependency Injection)
     *
     * @param parentActivity Activity onde este listener estiver sendo usado
     */
    public ProductDetailListener(Activity parentActivity) {
        this.parentActivity = parentActivity;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent it = new Intent(parentActivity, DetalhesProduto.class);
        parentActivity.startActivity(it);
    }
}
