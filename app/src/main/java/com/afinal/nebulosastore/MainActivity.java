package com.afinal.nebulosastore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Button volver, listar, crearRegistro;
    ListView listProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listProduct = findViewById(R.id.lv_datosProductos);
        volver = findViewById(R.id.btnVolver);
        crearRegistro=findViewById(R.id.btnRegistrarProducto);
        listar=findViewById(R.id.btnListarProducto);
        crearRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,RegistroProduct.class);
                startActivity(intent);
            }
        });
        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inten= new Intent(MainActivity.this,ListProduct.class);
                startActivity(inten);
            }
        });

    }
}