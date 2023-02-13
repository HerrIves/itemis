package de.herrives.models;

import de.herrives.models.items.Item;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCard {
    private Map<Item, Integer>basked;

    public ShoppingCard() {
        basked = new HashMap<>();
    }

    public ShoppingCard(Map<Item, Integer> basket) {
        this.basked = basket;
    }

    public Map<Item, Integer> getBasked() {
        return Collections.unmodifiableMap(basked);
    }

    public void addItem(Item item){
        basked.compute(item, (key, value) -> value == null ? 1 : (value + 1));
    }

    public ShoppingCard addItem(Item item, int quantity) {
        basked.put(item, quantity);
        return this;
    }

}
