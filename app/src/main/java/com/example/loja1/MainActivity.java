package com.example.loja1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private Button buttonCadastrarCliente, buttonMaiores, buttonCalculadora, buttonPontos, buttonPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciando os componentes do layout
        editTextNome = findViewById(R.id.editTextNome);
        buttonCadastrarCliente = findViewById(R.id.button2);
        buttonMaiores = findViewById(R.id.buttonMaiores);
        buttonCalculadora = findViewById(R.id.buttonEnviar);
        buttonPontos = findViewById(R.id.buttonPontos);
        buttonPreferencias = findViewById(R.id.buttonPreferencias);

        // Configurando os listeners para os botões
        buttonCadastrarCliente.setOnClickListener(view -> eventoBotao(view));

        buttonMaiores.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NovaActivity.class);
            startActivity(intent);
        });

        buttonCalculadora.setOnClickListener(view -> Toast.makeText(this, "Abrir calculadora", Toast.LENGTH_SHORT).show());

        buttonPontos.setOnClickListener(view -> {
            String nome = editTextNome.getText().toString();
            if (!nome.isEmpty()) {
                Toast.makeText(this, "Seu nome é: " + nome, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Digite seu nome primeiro!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonPreferencias.setOnClickListener(view -> Toast.makeText(this, "Abrir Preferências", Toast.LENGTH_SHORT).show());
    }

    public void eventoBotao(View view) {
        Toast.makeText(this, "O botão foi criado", Toast.LENGTH_SHORT).show();
    }
}
