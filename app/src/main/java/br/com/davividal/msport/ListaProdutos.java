package br.com.davividal.msport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import br.com.davividal.msport.Adapters.ProductDetailListener;
import br.com.davividal.msport.Domain.Entities.Produto;

public class ListaProdutos extends AppCompatActivity {
    Produto[] produtos = new Produto[]{
            new Produto("Bola de Futebol", "Bola de Futebol", 30d, R.drawable.bola_futebol),
            new Produto("Bola de Volei", "Bola de Volei", 10d, R.drawable.bola_volei),
            new Produto("Bola de Ping Pong", "Bola de Ping Pong", 30d, R.drawable.bola_ping_pong),
            new Produto("Bola de Basquete", "Bola de Basquete", 30d, R.drawable.bola_basquete),
            new Produto("Bola de Basquete", "Bola de Basquete", 30d, R.drawable.bola_basquete),
            new Produto("Bola de Basquete", "Bola de Basquete", 30d, R.drawable.bola_basquete),
            new Produto("Bola de Basquete", "Bola de Basquete", 30d, R.drawable.bola_basquete),
            new Produto("Bola de Basquete", "Bola de Basquete", 30d, R.drawable.bola_basquete),
            new Produto("Bola de Basquete", "Bola de Basquete", 30d, R.drawable.bola_basquete),
            new Produto("Bola de Basquete", "Bola de Basquete", 30d, R.drawable.bola_basquete),
            new Produto("Bola de Basquete", "Bola de Basquete", 30d, R.drawable.bola_basquete),
            new Produto("Bola de Basquete", "Bola de Basquete", 30d, R.drawable.bola_basquete),
            new Produto("Bola de Basquete", "Bola de Basquete", 30d, R.drawable.bola_basquete),
            new Produto("Bola de Basquete", "Bola de Basquete", 30d, R.drawable.bola_basquete),
            new Produto("Bola de Basquete", "Bola de Basquete", 30d, R.drawable.bola_basquete),
            new Produto("Bola de Basquete", "Bola de Basquete", 30d, R.drawable.bola_basquete),
            new Produto("Bola de Basquete", "Bola de Basquete", 30d, R.drawable.bola_basquete),
            new Produto("Bola de Basquete", "Bola de Basquete", 30d, R.drawable.bola_basquete),
            new Produto("Bola de Basquete", "Bola de Basquete", 30d, R.drawable.bola_basquete),
            new Produto("Camisa Atlético", "Camisa Atlético", 30d, R.drawable.camisa_atletico),
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
            listaProdutos.setOnItemClickListener(new ProductDetailListener(this));
        }
    }
}
