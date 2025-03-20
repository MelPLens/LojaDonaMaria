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

        // Referenciando
        editTextNome = findViewById(R.id.editTextNome);
        buttonCadastrarCliente = findViewById(R.id.button2);
        buttonMaiores = findViewById(R.id.buttonMaiores);
        buttonCalculadora = findViewById(R.id.buttonEnviar);
        buttonPontos = findViewById(R.id.buttonPontos);
        buttonPreferencias = findViewById(R.id.buttonPreferencias);


        buttonCadastrarCliente.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
            startActivity(intent);
        });

        buttonMaiores.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NovaActivity.class);
            startActivity(intent);
        });

        buttonCalculadora.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
            startActivity(intent);
        });

        buttonPontos.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DigitarActivity.class);
            startActivity(intent);
        });

        buttonPreferencias.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PreferenciasActivity.class);
            startActivity(intent);
        });
    }
}
