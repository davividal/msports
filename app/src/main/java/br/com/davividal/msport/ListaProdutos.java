package br.com.davividal.msport;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import br.com.davividal.msport.Adapters.ProductDetailListener;
import br.com.davividal.msport.Domain.Aggregates.Compras;
import br.com.davividal.msport.Domain.Entities.Produto;

public class ListaProdutos extends AppCompatActivity {
    private final Produto[] produtos = new Produto[]{
            new Produto("Bola de Futebol", "Bola de Futebol", 60d, R.drawable.bola_futebol),
            new Produto("Bola de Vôlei", "Bola de Vôlei", 35d, R.drawable.bola_volei),
            new Produto("Bola de Basquete", "Bola de Basquete", 70d, R.drawable.bola_basquete),
            new Produto("Camiseta do Coritiba", "Camiseta do Coritiba tamanho G   cor única", 180d, R.drawable.camisa_coritiba),
            new Produto("Camiseta do Atlético PR", "Camiseta do Atlético PR tamanho G   cor única", 150d, R.drawable.camisa_atletico),
            new Produto("Camiseta do Paraná Clube", "Camiseta do Paraná Clube tamanho G  cor única", 100d, R.drawable.camisa_parana_clube),
            new Produto("Camiseta Flamengo", "Camiseta Flamengo tamanho G  cor única", 100d, R.drawable.camisa_flamengo),
            new Produto("Camiseta Internacional", "Camiseta Internacional tamanho G, cor única", 100d, R.drawable.camisa_internacional),
            new Produto("Camiseta Grêmio", "Camiseta Grêmio tamanho G  cor única", 100d, R.drawable.camisa_gremio)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        br.com.davividal.msport.Adapters.ListaProdutos adapter = new br.com.davividal.msport.Adapters.ListaProdutos(
                ListaProdutos.this,
                produtos
        );

        ListView listaProdutos = (ListView) findViewById(R.id.lista_produtos);

        if (null != listaProdutos) {
            listaProdutos.setAdapter(adapter);
            listaProdutos.setOnItemClickListener(new ProductDetailListener(this, this.produtos));
        }

        Compras.getInstance().addProduto(produtos[0]);
    }

    public void relatorio(View view) {
        Intent it = new Intent(this, Relatorio.class);
        this.startActivity(it);
    }
}
