package com.example.shoppinglist;

import java.util.ArrayList;

public class ItemStorage {
    private ArrayList<String> items = new ArrayList<>();
    private static ItemStorage itemStorage = null;

    private ItemStorage(){
    }

    public static ItemStorage getInstance(){
        if(itemStorage == null){
            itemStorage = new ItemStorage();
        }
        return itemStorage;
    }

    public ArrayList<String> getItems(){
        return items;
    }

    public void addItem(String newItem){
        items.add(newItem);
    }

    public void removeItem(String itemToRemove) {
        int i= 0;
        for(String item : items) {
            if(items.get(i).equals(itemToRemove)) {
                break;
            }
            ++i;
        }
        items.remove(i);
    }
}
