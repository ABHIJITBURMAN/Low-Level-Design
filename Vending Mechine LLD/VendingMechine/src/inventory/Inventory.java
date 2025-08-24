package inventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    List<Item> itemList;
    Map<String,Integer> itemFrequency = new HashMap<>();;

    Map<String, Item> codeToItemMapper = new HashMap<>();

    public Inventory(){};


    public List<Item> getItems(){
        return this.itemList;
    }

    public void addItem(Item item, Integer quantity){
        itemFrequency.merge(item.code(), quantity, Integer::sum);
        if(!codeToItemMapper.containsKey(item.code())){
            codeToItemMapper.put(item.code(), item);
        }
    }

    public Item getItemByCode(String code){
        return codeToItemMapper.get(code);
    }

    public Boolean checkStock(Item item, Integer quantity){
        Integer existingQuantity = itemFrequency.get(item.code());
        return existingQuantity >= quantity;

    }

    public void dispenseItem(Item item, Integer quantity){
        Integer existingQuantity = itemFrequency.get(item.code());
        Integer updatedQuantity = existingQuantity-quantity;
        if(updatedQuantity == 0){
            codeToItemMapper.remove(item.code());
        }
        itemFrequency.put(item.code(), updatedQuantity);
    }
}
