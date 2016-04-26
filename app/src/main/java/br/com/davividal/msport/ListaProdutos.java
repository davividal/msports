package br.com.davividal.msport;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.davividal.msport.Adapters.ProductDetailListener;
import br.com.davividal.msport.Domain.Entities.Produto;

public class ListaProdutos extends AppCompatActivity {
    private final ArrayList<Produto> produtos = new ArrayList<>();
    protected br.com.davividal.msport.Adapters.ListaProdutos adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_produtos);

        adapter = new br.com.davividal.msport.Adapters.ListaProdutos(this, new ArrayList<Produto>());

        ProgressDialog dialog = new ProgressDialog(ListaProdutos.this);
        dialog.setMessage("Buscando produtos...");
        dialog.show();
        populateTable(dialog);
    }

    private void populateTable(ProgressDialog dialog) {
        ListView listaProdutos = (ListView) findViewById(R.id.lista_produtos);

        runOnUiThread(new Runnable() {
            private ProgressDialog dialog;
            private ListaProdutos activity;
            private ArrayList<Produto> produtos;
            private ListView listaProdutos;

            public void run() {
                produtos = initProdutos();

                for (Produto produto : produtos) {
                    adapter.add(produto);
                }

                if (null != listaProdutos) {
                    listaProdutos.setAdapter(adapter);
                    listaProdutos.setOnItemClickListener(new ProductDetailListener(activity, produtos));
                }

                dialog.dismiss();
            }

            public Runnable init(ProgressDialog dialog, ListaProdutos activity, ListView listaProdutos) {
                this.dialog = dialog;
                this.activity = activity;
                this.listaProdutos = listaProdutos;
                return this;
            }
        }.init(dialog, this, listaProdutos));
    }

    private ArrayList<Produto> initProdutos() {
        if (this.produtos.isEmpty()) {
            this.produtos.add(new Produto("Bola de Futebol", "Bola de Futebol", 60d, R.drawable.bola_futebol));
            this.produtos.add(new Produto("Bola de Vôlei", "Bola de Vôlei", 35d, R.drawable.bola_volei));
            this.produtos.add(new Produto("Bola de Basquete", "Bola de Basquete", 70d, R.drawable.bola_basquete));
            this.produtos.add(new Produto("Camiseta do Coritiba", "Camiseta do Coritiba tamanho G   cor única", 180d, R.drawable.camisa_coritiba));
            this.produtos.add(new Produto("Camiseta do Atlético PR", "Camiseta do Atlético PR tamanho G   cor única", 150d, R.drawable.camisa_atletico));
            this.produtos.add(new Produto("Camiseta do Paraná Clube", "Camiseta do Paraná Clube tamanho G  cor única", 100d, R.drawable.camisa_parana_clube));
            this.produtos.add(new Produto("Camiseta Flamengo", "Camiseta Flamengo tamanho G  cor única", 100d, R.drawable.camisa_flamengo));
            this.produtos.add(new Produto("Camiseta Internacional", "Camiseta Internacional tamanho G, cor única", 100d, R.drawable.camisa_internacional));
            this.produtos.add(new Produto("Camiseta Grêmio", "Camiseta Grêmio tamanho G  cor única", 100d, R.drawable.camisa_gremio));
        }

        return this.produtos;
    }

    public void relatorio(View view) {
        Intent it = new Intent(this, Relatorio.class);
        this.startActivity(it);
    }
}
