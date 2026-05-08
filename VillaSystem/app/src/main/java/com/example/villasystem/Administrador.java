package com.example.villasystem;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class Administrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_administrador);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        ImageButton imgBtnHome = findViewById(R.id.imgBtnHome);
        ImageButton imgBtnPerfil = findViewById(R.id.imgBtnPerfil);
        ImageButton imgBtnGalinha = findViewById(R.id.imgBtnGalinha);

        imgBtnHome.setOnClickListener(v -> {
            carregarFragment(new HomeFragment());
        });

        imgBtnPerfil.setOnClickListener(v -> {
            carregarFragment(new PerfilFragment());
        });

        imgBtnGalinha.setOnClickListener(v -> {
            carregarFragment(new CadastroPintinhoFragment());
        });
    }

    private void carregarFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right
                )
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}