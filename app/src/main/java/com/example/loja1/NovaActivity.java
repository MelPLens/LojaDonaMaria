package com.example.loja1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NovaActivity extends AppCompatActivity {

    private EditText editTextIdade;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova);

        editTextIdade = findViewById(R.id.editTextIdade);
        textViewResultado = findViewById(R.id.textViewResultado);
        Button buttonVerificar = findViewById(R.id.buttonVerificar);
        Button buttonVoltar = findViewById(R.id.buttonVoltar);

        buttonVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarIdade();
            }
        });

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NovaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void verificarIdade() {
        String idadeTexto = editTextIdade.getText().toString();

        if (idadeTexto.isEmpty()) {
            Toast.makeText(this, "Por favor, digite sua idade!", Toast.LENGTH_SHORT).show();
            return;
        }

        int idade = Integer.parseInt(idadeTexto);
        if (idade >= 18) {
            textViewResultado.setText("Você é maior de idade!");
        } else {
            textViewResultado.setText("Você é menor de idade!");
        }
    }
}
