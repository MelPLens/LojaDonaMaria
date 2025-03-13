package com.example.loja1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.loja1.NovaActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        EditText editText = findViewById(R.id.editTextNome);

        Button buttonEnviar = findViewById(R.id.buttonEnviar);
        buttonEnviar.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Botão pressionado!", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Seu nome é: " + editText.getText().toString(), Toast.LENGTH_SHORT).show();
        });


    }

    public void eventoBotao(View view) {
        Toast.makeText(this, "O botão foi criado", Toast.LENGTH_SHORT).show();
    }

    public void carregarActivityNova(View view) {
        Intent intent = new Intent(MainActivity.this, NovaActivity.class);
        startActivity(intent);
    }

}



