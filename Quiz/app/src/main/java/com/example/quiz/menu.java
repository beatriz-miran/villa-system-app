package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnJava = findViewById(R.id.btnJava);
        Button btnSql = findViewById(R.id.btnSql);
        Button btnSO = findViewById(R.id.btnSO);



        btnJava.setOnClickListener( v -> AbrirSorteio(1));
        btnSql.setOnClickListener( v -> AbrirSorteio(2));
        btnSO.setOnClickListener( v -> AbrirSorteio(3));

    }
    private void AbrirSorteio(int id){
        Intent intent = new Intent(menu.this, quiz.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }
}