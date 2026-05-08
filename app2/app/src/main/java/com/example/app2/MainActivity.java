package com.example.app2;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.splash), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });


        Button btn = findViewById(R.id.btnCalcular);
        EditText edTextMes1 = findViewById(R.id.edTextMes1);
        EditText edTextMes2 = findViewById(R.id.edTextMes2);
        EditText edTextMes3 = findViewById(R.id.edTextMes3);

        TextView tVMedia =  (TextView ) findViewById(R.id.tViewMedia);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double mes1, mes2, mes3, media;
                String situacao;

                mes1 = Double.parseDouble(edTextMes1.getText().toString());
                mes2 = Double.parseDouble(edTextMes2.getText().toString());
                mes3 = Double.parseDouble(edTextMes3.getText().toString());
                media  = (mes1 + mes2 + mes3) / 3;
                tVMedia.setText("A média de ovos por trimestre foi: " + (String.valueOf(media)));
            }

        });


        Button btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent telaPrincipal;
                telaPrincipal = new Intent(MainActivity.this, Login.class);
                startActivity(telaPrincipal);


            }
        });
    }
}