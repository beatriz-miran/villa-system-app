package com.example.loterias;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class mega extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mega);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner spNumeros;
        Spinner spJogos;
        Button btnCriar;
        ListView lstNumeros;

        ArrayList<String> resultados = new ArrayList<>();
        ArrayAdapter<String> adapter;

        Random random = new Random();

        int id = getIntent().getIntExtra("ID", 0);
        TextView txtTitulo = findViewById(R.id.txtTitulo);
        ImageView imgLogo = findViewById(R.id.imgLogo);
        spNumeros = findViewById(R.id.spNumeros);
        spJogos = findViewById(R.id.spJogos);
        btnCriar = findViewById(R.id.btnCriar);
        lstNumeros = findViewById(R.id.lstNumeros);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resultados);
        lstNumeros.setAdapter(adapter);


        switch (id){
            case 1:
                txtTitulo.setText("Quina");
                imgLogo.setImageResource(R.drawable.quinalogo);
                break;

            case 2:
                txtTitulo.setText("LotoFácil");
                imgLogo.setImageResource(R.drawable.lotofacilogo);
                break;

            case 3:
                txtTitulo.setText("Lotomania");
                imgLogo.setImageResource(R.drawable.lotomanialogo);
                break;

            case 4:
                txtTitulo.setText("Mega-Sena");
                imgLogo.setImageResource(R.drawable.megalogo);
                break;
        }

        btnCriar.setOnClickListener(view -> {

            resultados.clear();

            int qtdNumeros = Integer.parseInt(spNumeros.getSelectedItem().toString());
            int qtdJogos = Integer.parseInt(spJogos.getSelectedItem().toString());

            int maxNumero = 0;
            int inicio = 1;

            switch(id){

                case 1: // Quina
                    maxNumero = 80;
                    inicio = 1;
                    break;

                case 2: // Lotofácil
                    maxNumero = 25;
                    inicio = 1;
                    break;

                case 3: // Lotomania
                    maxNumero = 99;
                    inicio = 0;
                    qtdNumeros = 50;
                    break;

                case 4: // Mega-Sena
                    maxNumero = 60;
                    inicio = 1;
                    break;
            }

            for(int i = 0; i < qtdJogos; i++){

                ArrayList<Integer> jogo = gerarNumeros(qtdNumeros, maxNumero, inicio);

                resultados.add("Jogo " + (i+1) + ": " + jogo.toString());
            }

            adapter.notifyDataSetChanged();

        });


        Button btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaPrincipal;
                telaPrincipal = new Intent(mega.this, MainActivity.class);
                startActivity(telaPrincipal);
            }
        });


    }

    public ArrayList<Integer> gerarNumeros(int quantidade, int maxNumero, int inicio){

        ArrayList<Integer> numeros = new ArrayList<>();

        while(numeros.size() < quantidade){

            Random random = new Random();
            int numero = random.nextInt(maxNumero - inicio + 1) + inicio;

            if(!numeros.contains(numero)){
                numeros.add(numero);
            }
        }

        Collections.sort(numeros);

        return numeros;
    }
}