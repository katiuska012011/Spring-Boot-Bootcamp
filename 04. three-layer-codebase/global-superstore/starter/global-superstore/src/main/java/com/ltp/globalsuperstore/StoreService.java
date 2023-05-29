package com.ltp.globalsuperstore;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class StoreService {

    StoreReposity storeReposity = new StoreReposity();

    public void addItems(Item item) {
        storeReposity.addItems(item);
    }

    public void updateItems(Item item, int index) {
        storeReposity.updateItems(item, index);
    }

    public Item getItem(int id) {
        return storeReposity.getItem(id);
    }

    public List<Item> getItems() {
        return storeReposity.getItems();
    }

    public Item getItemById(String id){
        int index = getIndexById(id);
       return index == Constants.NOT_FOUND ? new Item() : getItem(index);
    }

    public String submitItem(Item item) {
        String status = Constants.SUCCESS_STATUS;

        int index = getIndexById(item.getId());
        if (index == Constants.NOT_FOUND) {
            addItems(item);
        } else if (within5Days(item.getDate(), getItem(index).getDate())) {
            updateItems(item, index);
        } else {
            status = Constants.FAILED_STATUS;
        }

        return status;
    }

    public List<Item> getInventory() {
        return getItems();
    }

    public int getIndexById(String id) {
        for (int i = 0; i < getItems().size(); i++) {
            if (getItem(i).getId().equals(id))
                return i;
        }
        return Constants.NOT_FOUND;
    }

    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }
}
