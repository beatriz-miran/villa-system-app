package com.example.app2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnLogin = findViewById(R.id.btnLogin);

        String senha = "123";
        String email = "bia@gmail.com";

        TextView textVErro =  (TextView ) findViewById(R.id.textVErro);

        EditText edTextEmail = findViewById(R.id.edTextEmail);
        EditText edTextSenha = findViewById(R.id.edTextSenha);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txtSenha = edTextSenha.getText().toString();
                String txtEmail = edTextEmail.getText().toString();

                if(txtEmail.equals(email) && txtSenha.equals(senha)) {
                    Intent telaPrincipal;
                    telaPrincipal = new Intent(Login.this, MainActivity.class);
                    startActivity(telaPrincipal);

                }else{
                    textVErro.setText("Senha ou e-mail incorretos.");
                }
            }

        });
    }
}