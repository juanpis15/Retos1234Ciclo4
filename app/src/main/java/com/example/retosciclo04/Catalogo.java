package com.example.retosciclo04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.retosciclo04.Adaptadores.ProductoAdapter;
import com.example.retosciclo04.DB.DBFirebase;
import com.example.retosciclo04.Entidades.Producto;

import java.util.ArrayList;

public class Catalogo extends AppCompatActivity {
    private DBFirebase dbFirebase;
    private ListView listViewProductos;
    private ProductoAdapter productoAdapter;
    private ArrayList<Producto> arrayProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        listViewProductos = (ListView) findViewById(R.id.listViewProductos);
        arrayProductos = new ArrayList<>();
        dbFirebase = new DBFirebase();

        /*CREACION LISTO DE PRODUCTOS

        Producto producto1 = new Producto("Tornillos",       "Set de Tornillos",        2000,R.drawable.img_tornillos,          "", "");
        Producto producto2 = new Producto("Destornilladores","Set de destornilladores", 32000,R.drawable.img_destornilladores,  "", "");
        Producto producto3 = new Producto("llave inglesa",   "Set de llaves inglesas",  25000,R.drawable.img_juego_llaves,      "", "");

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);*/

        productoAdapter = new ProductoAdapter(this, arrayProductos);
        listViewProductos.setAdapter(productoAdapter);
        dbFirebase.getData(productoAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.itemAdd:
                intent =new Intent(getApplicationContext(),Form.class);
                startActivity(intent);
                return true;
            case R.id.itemMap:
                intent =new Intent(getApplicationContext(),Maps.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}