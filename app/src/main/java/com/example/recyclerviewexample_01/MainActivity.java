package com.example.recyclerviewexample_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ItemList> items=new ArrayList<>();

    Button register;

    TextInputLayout name, color, city, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register= findViewById(R.id.btnRegister);
        name=findViewById(R.id.hotel_name);
        color=findViewById(R.id.hotel_color);
        city=findViewById(R.id.hotel_city);
        status=findViewById(R.id.hotel_status);

        constructorList();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ItemList item= new ItemList(name.getEditText().getText().toString(),
                                            color.getEditText().getText().toString(),
                                            city.getEditText().getText().toString(),
                                            status.getEditText().getText().toString());
                addItemList(item);
                clean();
            }
        });

    }

    public void init(){

        ItemListAdapter itemListAdapter= new ItemListAdapter(items,this);
        RecyclerView recyclerView= findViewById(R.id.rvItems);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemListAdapter);


    }

    public void constructorList(){
        items.add(new ItemList("Hotel Estelar","#FFF44336","Manizales","Disponible"));
        items.add(new ItemList("Hotel Decameron","#123e07","Amazonas","Disponible"));
        items.add(new ItemList("Hotel Dann Carlton","#1e2c53","Bogotá","No Disponible"));
        items.add(new ItemList("Hotel Tequendama","#0cab0a","Medellín","No Disponible"));
        items.add(new ItemList("Hotel Sophia","#ffe038","Cartagena","Disponible"));
        items.add(new ItemList("Hotel Casablanca","#00feff","San Andres","No Disponible"));
        items.add(new ItemList("Hotel Windsor","#f2e98d","Barranquilla","Disponible"));
        init();
    }

    public void addItemList(ItemList hotel){
        items.add(new ItemList(hotel.getName(), hotel.getColor(), hotel.getCity(), hotel.getStatus()));
        init();
    }

    public void clean(){
        name.getEditText().setText("");
        color.getEditText().setText("");
        city.getEditText().setText("");
        status.getEditText().setText("");
    }

}