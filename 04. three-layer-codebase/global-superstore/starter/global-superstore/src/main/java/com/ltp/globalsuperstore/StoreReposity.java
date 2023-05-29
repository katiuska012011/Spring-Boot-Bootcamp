package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.List;


public class StoreReposity {
    
    List<Item> items = new ArrayList<>();

    public void addItems(Item item){
        items.add(item);
    }

    public void updateItems(Item item, int index){
        items.set(index, item);
    }

    public Item getItem(int id){
        return items.get(id);
    } 

    public List<Item> getItems(){
        return items;
    }
}
