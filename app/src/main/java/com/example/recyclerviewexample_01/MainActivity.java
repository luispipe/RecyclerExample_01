package com.example.recyclerviewexample_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ItemList> items=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        items.add(new ItemList("Hotel Estelar","#FFF44336","Manizales","Disponible"));
        items.add(new ItemList("Hotel Decameron","#FFF44336","Amazonas","Disponible"));
        items.add(new ItemList("Hotel Dann Carlton","#FFF44336","Bogotá","No Disponible"));
        items.add(new ItemList("Hotel Tequendama","#FFF44336","Medellín","No Disponible"));
        items.add(new ItemList("Hotel Sophia","#FFF44336","Cartagena","Disponible"));
        items.add(new ItemList("Hotel Casablanca","#FFF44336","San Andres","No Disponible"));
        items.add(new ItemList("Hotel Windsor","#FFF44336","Barranquilla","Disponible"));

        ItemListAdapter itemListAdapter= new ItemListAdapter(items,this);
        RecyclerView recyclerView= findViewById(R.id.rvItems);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemListAdapter);


    }
}