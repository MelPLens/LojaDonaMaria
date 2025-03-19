package com.example.loja1;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText editTextNome, editTextIdade, editTextUF, editTextCidade, editTextTelefone, editTextEmail;
    private RadioGroup radioGroupTamanho;
    private CheckBox checkboxVermelho, checkboxAzul, checkboxPreto, checkboxBranco;
    private Button buttonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // Referenciando os elementos da interface
        editTextNome = findViewById(R.id.editTextNome);
        editTextIdade = findViewById(R.id.editTextIdade);
        editTextUF = findViewById(R.id.editTextUF);
        editTextCidade = findViewById(R.id.editTextCidade);
        editTextTelefone = findViewById(R.id.editTextTelefone);
        editTextEmail = findViewById(R.id.editTextEmail);
        radioGroupTamanho = findViewById(R.id.radioGroupTamanho);
        checkboxVermelho = findViewById(R.id.checkboxVermelho);
        checkboxAzul = findViewById(R.id.checkboxAzul);
        checkboxPreto = findViewById(R.id.checkboxPreto);
        checkboxBranco = findViewById(R.id.checkboxBranco);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);

        // Ação do botão de cadastro
        buttonCadastrar.setOnClickListener(view -> cadastrarUsuario());
    }

    private void cadastrarUsuario() {
        String nome = editTextNome.getText().toString();
        String idade = editTextIdade.getText().toString();
        String uf = editTextUF.getText().toString();
        String cidade = editTextCidade.getText().toString();
        String telefone = editTextTelefone.getText().toString();
        String email = editTextEmail.getText().toString();

        if (nome.isEmpty() || idade.isEmpty() || uf.isEmpty() || cidade.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificando o tamanho da roupa selecionado
        int selectedTamanhoId = radioGroupTamanho.getCheckedRadioButtonId();
        RadioButton radioButtonTamanho = findViewById(selectedTamanhoId);
        String tamanho = radioButtonTamanho != null ? radioButtonTamanho.getText().toString() : "Não selecionado";

        // Verificando as cores preferidas selecionadas
        StringBuilder coresPreferidas = new StringBuilder();
        if (checkboxVermelho.isChecked()) coresPreferidas.append("Vermelho, ");
        if (checkboxAzul.isChecked()) coresPreferidas.append("Azul, ");
        if (checkboxPreto.isChecked()) coresPreferidas.append("Preto, ");
        if (checkboxBranco.isChecked()) coresPreferidas.append("Branco, ");

        // Remover a última vírgula
        if (coresPreferidas.length() > 0) {
            coresPreferidas.setLength(coresPreferidas.length() - 2); // Remover a vírgula e espaço finais
        }

        // Exibindo os dados
        String mensagem = "Nome: " + nome + "\nIdade: " + idade + "\nUF: " + uf + "\nCidade: " + cidade
                + "\nTelefone: " + telefone + "\nEmail: " + email + "\nTamanho de Roupa: " + tamanho
                + "\nCores Preferidas: " + coresPreferidas.toString();

        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}
