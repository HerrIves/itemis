package shoppingcard;

import items.Item;
import items.UnknownItem;
import org.junit.Assert;
import org.junit.Test;

public class ShoppingCardTest {

    @Test
    public void isBaskedExist(){
        ShoppingCard card = new ShoppingCard();

        Assert.assertTrue(card.getBasked() != null);
    }

    @Test
    public void addItemTest(){
        ShoppingCard card = new ShoppingCard();
        Item item = new UnknownItem("book am westen nichts neues", 12.49);
        card.addItem(item);
        card.addItem(item);

        System.out.println(card.getBasked());

        Assert.assertTrue(card.getBasked().containsKey(item));
    }
}
