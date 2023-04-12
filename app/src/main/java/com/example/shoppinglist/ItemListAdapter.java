package com.example.shoppinglist;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListHolder>{
    private Context context;
    private ArrayList<String> items = new ArrayList<>();
    boolean editingText;
    ImageView btnSortByDate;
    TextView btnSortByAlphabet;

    public ItemListAdapter(Context context, ArrayList<String> items, ImageView btnSortByDate, TextView btnSortByAlphabet) {
        this.context = context;
        this.items = items;
        this.btnSortByDate = btnSortByDate;
        this.btnSortByAlphabet = btnSortByAlphabet;
    }

    @NonNull
    @Override
    public ItemListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemListHolder(LayoutInflater.from(context).inflate(R.layout.shopping_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListHolder holder, int position) {
        holder.txtShopItemDetails.setText(items.get(position));
        editingText = false;
        holder.txtUpdated.setText(items.get(position));

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                ItemStorage.getInstance().removeItem(items.get(pos));
                notifyItemRemoved(pos);
            }
        });

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editingText) {
                    editingText = false;
                    holder.txtShopItemDetails.setText(holder.txtUpdated.getText());
                    holder.txtShopItemDetails.setVisibility(View.VISIBLE);
                    holder.txtUpdated.setVisibility(View.GONE);
                } else { // ei ollut näkymänä auki
                    int pos = holder.getAdapterPosition();
                    editingText = true;
                    holder.txtShopItemDetails.setVisibility(View.GONE);
                    holder.txtUpdated.setVisibility(View.VISIBLE);
                    System.out.println(holder.txtShopItemDetails.getText());
                }
            }
        });

        btnSortByDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items = ItemStorage.getInstance().getItems();
                System.out.println(ItemStorage.getInstance().getItems());
                notifyDataSetChanged();
            }
        });

        btnSortByAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> newItems = new ArrayList<>(items);
                Collections.sort(newItems);
                items = newItems;
                System.out.println(ItemStorage.getInstance().getItems());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
