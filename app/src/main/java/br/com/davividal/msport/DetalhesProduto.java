package br.com.davividal.msport;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.davividal.msport.Domain.Aggregates.Compras;
import br.com.davividal.msport.Domain.Entities.Produto;

public class DetalhesProduto extends AppCompatActivity {
    private Compras compras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalhes_produto);
        Produto produto = (Produto) this.getIntent().getSerializableExtra("produto");

        compras = Compras.getInstance();

        EditText description = (EditText) findViewById(R.id.text_description);
        assert description != null;
        description.setText(produto.getDescricao());

        ImageView image = (ImageView) findViewById(R.id.product_image);
        assert image != null;
        image.setImageResource(produto.getImagem());

        TextView preco = (TextView) findViewById(R.id.textView_preco);
        assert preco != null;
        preco.setText(produto.getValor());
    }

    public void buy(View view) {
        Produto produto = (Produto) this.getIntent().getSerializableExtra("produto");
        compras.addProduto(produto);
        Toast.makeText(DetalhesProduto.this, "Comprou o produto" + produto.getNome(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
