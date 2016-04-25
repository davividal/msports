package br.com.davividal.msport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import br.com.davividal.msport.Adapters.RelatorioCompras;
import br.com.davividal.msport.Domain.Aggregates.Compras;

public class Relatorio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);
        Compras compras = Compras.getInstance();

        RelatorioCompras adapter = new RelatorioCompras(
                Relatorio.this,
                compras.getProdutos()
        );

        ListView listaProdutos = (ListView) findViewById(R.id.lista_produtos);
        TextView total = (TextView) findViewById(R.id.total);

        if (null != listaProdutos && null != total) {
            listaProdutos.setAdapter(adapter);
            total.setText(compras.getTotal());
        }
    }
}
