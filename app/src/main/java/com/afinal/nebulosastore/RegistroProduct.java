package com.afinal.nebulosastore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.afinal.nebulosastore.Model.Producto;

import java.util.UUID;

public class RegistroProduct extends AppCompatActivity {
    Button registrar,volver;
    EditText nombrP, descripcioP, cantidaP, preciP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_product);
        nombrP = findViewById(R.id.editTextTextNombreProducto);
        descripcioP = findViewById(R.id.editTextTextDescripcion);
        cantidaP = findViewById(R.id.editTextTextCantidad);
        preciP = findViewById(R.id.editTextTextPrecio);
        registrar = findViewById(R.id.btnRegistroProducto);
        volver = findViewById(R.id.btnVolver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inten= new Intent(RegistroProduct.this,MainActivity.class);
                startActivity(inten);
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombrP.getText().toString();
                String descripcion = descripcioP.getText().toString();
                String cantidad = cantidaP.getText().toString();
                String precio = preciP.getText().toString();
                if (nombre.equals("")||descripcion.equals("")||cantidad.equals("")||precio.equals("")) {
                    validacion();
                }
                else {
                    Producto p=new Producto();
                    p.setUid(UUID.randomUUID().toString());
                    p.setNombre(nombre);
                    p.setCantidad(cantidad);
                    p.setDescripcion(descripcion);
                    p.setPrecio(precio);
                    limpiarCajas();
                    Intent inten= new Intent(RegistroProduct.this,ListProduct.class);
                    startActivity(inten);
                }
            }


        });


    }
    private void limpiarCajas() {
        nombrP.setText("");
        descripcioP.setText("");
        cantidaP.setText("");
        preciP.setText("");
    }

    private void validacion() {
        String nombre = nombrP.getText().toString();
        String descripcion = descripcioP.getText().toString();
        String cantidad = cantidaP.getText().toString();
        String precio = preciP.getText().toString();
        if (nombre.equals("")) {
            nombrP.setError("Required");
        } else if (precio.equals("")) {
            preciP.setError("Required");
        } else if (descripcion.equals("")) {
            descripcioP.setError("Required");
        } else if (cantidad.equals("")) {
            cantidaP.setError("Required");
        }
    }
}