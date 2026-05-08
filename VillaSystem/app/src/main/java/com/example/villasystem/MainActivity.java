package com.example.villasystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String admUsu = "";
        String admSen = "";

        Button btnAcessar = findViewById(R.id.btnAcessar);
        TextView txtErro = findViewById(R.id.txtErro);
        EditText edTextSen = findViewById(R.id.edTextSen);
        EditText edTextUsu = findViewById(R.id.edTextUsu);

        btnAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edTextUsu.getText().toString().equals(admUsu) && edTextSen.getText().toString().equals(admSen) ){
                    Intent i = new Intent(MainActivity.this, Administrador.class);
                    startActivity(i);
                    finish();
                }
                else{
                    txtErro.setText("Usuário ou senha incorretos. Tente novamente.");
                }
            }
        });
    }
}