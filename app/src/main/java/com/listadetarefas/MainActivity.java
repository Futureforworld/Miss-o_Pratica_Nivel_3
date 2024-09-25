package com.listadetarefas;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button addButton;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando ListView e Button
        listView = findViewById(R.id.listView);
        addButton = findViewById(R.id.addButton);

        // Inicializando lista e adapter
        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);

        // Configurando o adapter no ListView
        listView.setAdapter(adapter);

        // Ação do botão para adicionar itens à lista
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = "Item " + (itemList.size() + 1);
                itemList.add(newItem);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, newItem + " adicionado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
