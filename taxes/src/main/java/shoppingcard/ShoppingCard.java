package shoppingcard;

import items.Item;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCard {
    Map<Item, Integer>basked;

    public ShoppingCard() {
        basked = new HashMap<>();
    }

    public Map<Item, Integer> getBasked() {
        return Collections.<Item, Integer>unmodifiableMap(basked);
    }
}
