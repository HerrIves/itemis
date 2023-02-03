package shoppingcard;

import items.Book;
import items.Item;
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
        Item item = new Book();
        card.addItem(item);
        card.addItem(item);

        System.out.println(card.getBasked());

        Assert.assertTrue(card.getBasked().containsKey(item));
    }
}
