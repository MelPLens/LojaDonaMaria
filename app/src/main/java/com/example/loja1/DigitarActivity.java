package com.example.loja1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class DigitarActivity extends AppCompatActivity {

    private EditText editTextNome;
    private LinearLayout checkBoxContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digitar);

        editTextNome = findViewById(R.id.editTextNome);
        checkBoxContainer = findViewById(R.id.checkBoxContainer);

        editTextNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                atualizarCheckBoxes(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void atualizarCheckBoxes(String nome) {
        checkBoxContainer.removeAllViews(); // Remove os checkboxes antigos

        for (char letra : nome.toCharArray()) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(String.valueOf(letra));
            checkBoxContainer.addView(checkBox);
        }
    }
}
