package shoppingcard;

import org.junit.Assert;
import org.junit.Test;

public class ShoppingCardTest {

    @Test
    public void isBaskedExist(){
        ShoppingCard card = new ShoppingCard();

        Assert.assertTrue(card.getBasked() != null);
    }
}
