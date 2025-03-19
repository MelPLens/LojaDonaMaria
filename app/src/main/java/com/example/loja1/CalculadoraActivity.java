package com.example.loja1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalculadoraActivity extends AppCompatActivity {

    private EditText editTextNumero1, editTextNumero2;
    private TextView textViewResultado;
    private Button buttonSomar, buttonSubtrair, buttonMultiplicar, buttonDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        // Referenciando os elementos da interface
        editTextNumero1 = findViewById(R.id.editTextNumero1);
        editTextNumero2 = findViewById(R.id.editTextNumero2);
        textViewResultado = findViewById(R.id.textViewResultado);
        buttonSomar = findViewById(R.id.buttonSomar);
        buttonSubtrair = findViewById(R.id.buttonSubtrair);
        buttonMultiplicar = findViewById(R.id.buttonMultiplicar);
        buttonDividir = findViewById(R.id.buttonDividir);

        // Configurando os botões
        buttonSomar.setOnClickListener(view -> calcular('+'));
        buttonSubtrair.setOnClickListener(view -> calcular('-'));
        buttonMultiplicar.setOnClickListener(view -> calcular('*'));
        buttonDividir.setOnClickListener(view -> calcular('/'));
    }

    private void calcular(char operacao) {
        String numero1Str = editTextNumero1.getText().toString();
        String numero2Str = editTextNumero2.getText().toString();

        if (numero1Str.isEmpty() || numero2Str.isEmpty()) {
            Toast.makeText(this, "Digite ambos os números!", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(numero1Str);
        double num2 = Double.parseDouble(numero2Str);
        double resultado = 0;

        switch (operacao) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    Toast.makeText(this, "Divisão por zero não é permitida!", Toast.LENGTH_SHORT).show();
                    return;
                }
                resultado = num1 / num2;
                break;
        }

        textViewResultado.setText("Resultado: " + resultado);
    }
}
