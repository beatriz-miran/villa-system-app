package com.example.loterias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    LinearLayout lotMega, lotLotofacil, lotLotomania;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnMega = findViewById(R.id.btnMega);
        Button btnQuina = findViewById(R.id.btnQuina);
        Button btnLotofacil = findViewById(R.id.btnLotofacil);
        Button btnLotomania = findViewById(R.id.btnLotomania);

        btnMega.setOnClickListener( v -> AbrirSorteio(0));
        btnQuina.setOnClickListener( v -> AbrirSorteio(1));
        btnLotofacil.setOnClickListener( v -> AbrirSorteio(2));
        btnLotomania.setOnClickListener( v -> AbrirSorteio(3));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnMega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaPrincipal;
                telaPrincipal = new Intent(MainActivity.this, mega.class);
                startActivity(telaPrincipal);
            }
        });
    }
    private void AbrirSorteio(int id){
        Intent intent = new Intent(MainActivity.this, mega.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }

}