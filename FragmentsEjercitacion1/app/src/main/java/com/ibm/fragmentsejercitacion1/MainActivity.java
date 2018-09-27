package com.ibm.fragmentsejercitacion1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonCambioVerde = findViewById(R.id.button_cargar_verde);
        Button botonCambioRojo = findViewById(R.id.button_cargar_rojo);

        botonCambioVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarFragment(new FragmentFondoVerde());
            }
        });

        botonCambioRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarFragment(new FragmentFondoRojo());
            }
        });
    }

    public void cambiarFragment(android.support.v4.app.Fragment unFragment){

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.layout_container, unFragment);

        transaction.addToBackStack("Verde");

        transaction.commit();

    }
}
