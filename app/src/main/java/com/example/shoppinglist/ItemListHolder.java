package com.example.shoppinglist;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemListHolder extends RecyclerView.ViewHolder {
    TextView txtShopItemDetails;
    ImageView btnEdit;
    ImageView btnDelete;
    EditText txtUpdated;
    ImageView btnSortByDate;
    TextView btnSortByAlphabet;

    public ItemListHolder(@NonNull View itemView){
        super(itemView);

        this.txtShopItemDetails = itemView.findViewById(R.id.txtShopItemDetails);
        this.btnEdit = itemView.findViewById(R.id.btnEdit);
        this.btnDelete = itemView.findViewById(R.id.btnDelete);
        this.txtUpdated = itemView.findViewById(R.id.txtUpdatedText);
    }
}
