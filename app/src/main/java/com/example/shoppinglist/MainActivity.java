package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText addNewItemText;
    ImageView imgSave;

    Button addItem;
    RecyclerView rvItems;

    ItemStorage storage;
    MainActivity main;

    ImageView btnSortByDate;
    TextView btnSortByAlphabet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Alustetaan arvot ja muutetaan näkymättömiksi
        addNewItemText = findViewById(R.id.txtInputMultiLine);
        imgSave = findViewById(R.id.btnSave);
        addNewItemText.setVisibility(View.GONE);
        imgSave.setVisibility(View.GONE);

        // haetaan arvot
        addItem = findViewById(R.id.btnAddItem);
        storage = ItemStorage.getInstance();
        main = this;

        btnSortByDate = findViewById(R.id.btnSortByDate);
        btnSortByAlphabet = findViewById(R.id.btnSortByAlphabet);

        rvItems = findViewById(R.id.rvItems);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        rvItems.setAdapter(new ItemListAdapter(getApplicationContext(), storage.getItems(), btnSortByDate, btnSortByAlphabet));

        // event'handleri sille, että käyttäjä lisää uuden esineen
        imgSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (addNewItemText.getText().length() > 0){
                    storage.addItem(String.valueOf(addNewItemText.getText()));
                    rvItems.setLayoutManager(new LinearLayoutManager(main));
                    rvItems.setAdapter(new ItemListAdapter(getApplicationContext(), storage.getItems(), btnSortByDate, btnSortByAlphabet));
                    //rvItems.getAdapter().notifyDataSetChanged();
                    addNewItemText.setText("");
                }

                addNewItemText.setVisibility(View.GONE);
                imgSave.setVisibility(View.GONE);
            }
        });

    }

    public void btnAddItem(View view){
        addNewItemText.setVisibility(View.VISIBLE);
        imgSave.setVisibility(View.VISIBLE);
    }
}