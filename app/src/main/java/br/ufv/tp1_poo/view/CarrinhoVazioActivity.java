package br.ufv.tp1_poo.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import br.ufv.tp1_poo.R;

public class CarrinhoVazioActivity extends AppCompatActivity {

    private TextView botaoVoltar;
    private TextView botaoVoltarInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Habilita o uso de tela cheia
        setContentView(R.layout.activity_carrinho_vazio);

        botaoVoltar = findViewById(R.id.botaoVoltar);
        botaoVoltarInicial = findViewById(R.id.botaoVoltarInicial);

        // Ação dos buttons
        botaoVoltar.setOnClickListener(v -> finish()); // Finaliza a atividade atual
        botaoVoltarInicial.setOnClickListener(v -> {
            Intent intent = new Intent(CarrinhoVazioActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}