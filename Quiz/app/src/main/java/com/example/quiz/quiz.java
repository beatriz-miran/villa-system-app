package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class quiz extends AppCompatActivity {

    int respostaCorreta1Id = -1;
    int respostaCorreta2Id = -1;

    int indice = 0;
    double pontuacao = 0;

    ArrayList<Pergunta> perguntas = new ArrayList<>();

    TextView txtMateria, txtPgt, txtPgt2;
    RadioGroup rdgPergunta1, rdgPergunta2;
    RadioButton rb1, rb2, rb3, rb4, rb5, rb6;
    Button btnProx, btnVoltar;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);

        txtMateria = findViewById(R.id.txtMateria);
        txtPgt = findViewById(R.id.txtPgt);
        txtPgt2 = findViewById(R.id.txtPgt2);

        rdgPergunta1 = findViewById(R.id.rdgPergunta1);
        rdgPergunta2 = findViewById(R.id.rdgPergunta2);

        rb1 = findViewById(R.id.rbPerg1);
        rb2 = findViewById(R.id.rbPerg2);
        rb3 = findViewById(R.id.rbPerg3);
        rb4 = findViewById(R.id.rbPerg4);
        rb5 = findViewById(R.id.rbPerg5);
        rb6 = findViewById(R.id.rbPerg6);

        btnProx = findViewById(R.id.btnProx);
        btnVoltar = findViewById(R.id.btnVoltar);

        id = getIntent().getIntExtra("ID", 0);

        carregarPerguntas();
        mostrarPerguntas();

        btnProx.setOnClickListener(v -> responder());

        btnVoltar.setOnClickListener(v ->
                startActivity(new Intent(this, menu.class))
        );
    }

    void mostrarPerguntas() {

        rdgPergunta1.clearCheck();
        rdgPergunta2.clearCheck();

        Pergunta p1 = perguntas.get(indice);
        Pergunta p2 = perguntas.get(indice + 1);

        txtPgt.setText(p1.pergunta);
        txtPgt2.setText(p2.pergunta);

        rb1.setText(p1.opcoes[0]);
        rb2.setText(p1.opcoes[1]);
        rb3.setText(p1.opcoes[2]);

        rb4.setText(p2.opcoes[0]);
        rb5.setText(p2.opcoes[1]);
        rb6.setText(p2.opcoes[2]);

        respostaCorreta1Id = getIdCorreto(p1.resposta, rb1, rb2, rb3);
        respostaCorreta2Id = getIdCorreto(p2.resposta, rb4, rb5, rb6);
    }

    void responder() {

        int sel1 = rdgPergunta1.getCheckedRadioButtonId();
        int sel2 = rdgPergunta2.getCheckedRadioButtonId();

        if (sel1 == -1 || sel2 == -1) {
            Toast.makeText(this, "Responda as duas perguntas!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (sel1 == respostaCorreta1Id) pontuacao += 1;
        else pontuacao -= 0.20;

        if (sel2 == respostaCorreta2Id) pontuacao += 1;
        else pontuacao -= 0.20;

        indice += 2;

        if (indice < perguntas.size()) {
            mostrarPerguntas();
        } else {
            String msg = String.format(Locale.getDefault(),
                    "🎉 Finalizado!\nPontuação: %.2f", pontuacao);

            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            btnProx.setEnabled(false);
        }
    }

    int getIdCorreto(String resposta, RadioButton a, RadioButton b, RadioButton c) {
        if (a.getText().toString().equals(resposta)) return a.getId();
        if (b.getText().toString().equals(resposta)) return b.getId();
        return c.getId();
    }

    void carregarPerguntas() {

        if (id == 1) {
            txtMateria.setText("Java");

            perguntas.add(new Pergunta("Tipo do main?",
                    new String[]{"void","int","String"},
                    "void"));

            perguntas.add(new Pergunta("Scanner está em?",
                    new String[]{"java.util","java.io","java.lang"},
                    "java.util"));

            perguntas.add(new Pergunta("Herança?",
                    new String[]{"extends","implements","inherits"},
                    "extends"));

            perguntas.add(new Pergunta("Modificador global?",
                    new String[]{"public","private","protected"},
                    "public"));

            perguntas.add(new Pergunta("Try-catch serve?",
                    new String[]{"Tratar erro","Loop","Condição"},
                    "Tratar erro"));

            perguntas.add(new Pergunta("Constante?",
                    new String[]{"final","const","static"},
                    "final"));

            perguntas.add(new Pergunta("Classe pai?",
                    new String[]{"Object","Main","Class"},
                    "Object"));

            perguntas.add(new Pergunta("Comparação correta?",
                    new String[]{"equals()","==","compare"},
                    "equals()"));

            perguntas.add(new Pergunta("Interface?",
                    new String[]{"interface","abstract","implements"},
                    "interface"));

            perguntas.add(new Pergunta("Loop?",
                    new String[]{"for","if","case"},
                    "for"));
        }

        if (id == 2) {
            txtMateria.setText("SQL");

            perguntas.add(new Pergunta("Valores únicos?",
                    new String[]{"DISTINCT","UNIQUE","ONLY"},
                    "DISTINCT"));

            perguntas.add(new Pergunta("Contar?",
                    new String[]{"COUNT()","SUM()","TOTAL()"},
                    "COUNT()"));

            perguntas.add(new Pergunta("Agrupar?",
                    new String[]{"GROUP BY","ORDER BY","WHERE"},
                    "GROUP BY"));

            perguntas.add(new Pergunta("Filtrar agregação?",
                    new String[]{"HAVING","WHERE","GROUP"},
                    "HAVING"));

            perguntas.add(new Pergunta("Alterar tabela?",
                    new String[]{"ALTER TABLE","UPDATE","CHANGE"},
                    "ALTER TABLE"));

            perguntas.add(new Pergunta("Apagar tudo?",
                    new String[]{"TRUNCATE","DELETE","DROP"},
                    "TRUNCATE"));

            perguntas.add(new Pergunta("Maior que?",
                    new String[]{">","<","="},
                    ">"));

            perguntas.add(new Pergunta("AND?",
                    new String[]{"AND","&&","&"},
                    "AND"));

            perguntas.add(new Pergunta("Criar banco?",
                    new String[]{"CREATE DATABASE","NEW","MAKE"},
                    "CREATE DATABASE"));

            perguntas.add(new Pergunta("Remover banco?",
                    new String[]{"DROP DATABASE","DELETE","REMOVE"},
                    "DROP DATABASE"));
        }

        if (id == 3) {
            txtMateria.setText("Sistemas Operacionais");

            perguntas.add(new Pergunta("Processo?",
                    new String[]{"Programa em execução","Arquivo","Memória"},
                    "Programa em execução"));

            perguntas.add(new Pergunta("Thread?",
                    new String[]{"Parte do processo","Sistema","Hardware"},
                    "Parte do processo"));

            perguntas.add(new Pergunta("Scheduler?",
                    new String[]{"Gerencia CPU","Disco","Rede"},
                    "Gerencia CPU"));

            perguntas.add(new Pergunta("Memória virtual?",
                    new String[]{"Simulação RAM","HD","Cache"},
                    "Simulação RAM"));

            perguntas.add(new Pergunta("Deadlock?",
                    new String[]{"Bloqueio","Erro","Rede"},
                    "Bloqueio"));

            perguntas.add(new Pergunta("Sistema de arquivos?",
                    new String[]{"Organiza dados","Executa","CPU"},
                    "Organiza dados"));

            perguntas.add(new Pergunta("Swap?",
                    new String[]{"Troca RAM/HD","CPU","Cache"},
                    "Troca RAM/HD"));

            perguntas.add(new Pergunta("Kernel?",
                    new String[]{"Gerencia hardware","Interface","App"},
                    "Gerencia hardware"));

            perguntas.add(new Pergunta("Shell?",
                    new String[]{"Interface usuário","Hardware","Memória"},
                    "Interface usuário"));

            perguntas.add(new Pergunta("Multitarefa?",
                    new String[]{"Vários processos","Um","Nenhum"},
                    "Vários processos"));
        }
    }

    class Pergunta {
        String pergunta;
        String[] opcoes;
        String resposta;

        Pergunta(String pergunta, String[] opcoes, String resposta) {
            this.pergunta = pergunta;
            this.opcoes = opcoes;
            this.resposta = resposta;
        }
    }
}