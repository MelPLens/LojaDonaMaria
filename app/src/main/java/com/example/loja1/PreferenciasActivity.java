package com.example.loja1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PreferenciasActivity extends AppCompatActivity {

    private CheckBox checkBoxNotificacoes, checkBoxModoEscuro, checkBoxLembrarLogin;
    private Button buttonSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

        checkBoxNotificacoes = findViewById(R.id.checkBoxNotificacoes);
        checkBoxModoEscuro = findViewById(R.id.checkBoxModoEscuro);
        checkBoxLembrarLogin = findViewById(R.id.checkBoxLembrarLogin);
        buttonSalvar = findViewById(R.id.buttonSalvar);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarPreferencias();
            }
        });
    }

    private void salvarPreferencias() {
        StringBuilder mensagem = new StringBuilder("Preferências escolhidas:\n");

        if (checkBoxNotificacoes.isChecked()) {
            mensagem.append("- Receber notificações\n");
        }
        if (checkBoxModoEscuro.isChecked()) {
            mensagem.append("- Modo escuro\n");
        }
        if (checkBoxLembrarLogin.isChecked()) {
            mensagem.append("- Lembrar login\n");
        }

        if (mensagem.toString().equals("Preferências escolhidas:\n")) {
            mensagem = new StringBuilder("Nenhuma preferência foi escolhida.");
        }

        Toast.makeText(this, mensagem.toString(), Toast.LENGTH_SHORT).show();
    }
}
