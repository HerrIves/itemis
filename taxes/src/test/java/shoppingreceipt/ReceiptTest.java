package shoppingreceipt;

import items.*;
import org.junit.Assert;
import org.junit.Test;
import shoppingcard.ShoppingCard;

public class ReceiptTest {

    @Test
    public void receiptOutputTest(){
        ShoppingCard card = new ShoppingCard();
//        card.addItem(new Book("am westen nichts neues", 12.49));
        Item item = new UnknownItem("book am westen nichts neues", 12.49);
        item.setIsExempt(true);

        card.addItem(item);

        Receipt receipt = new Receipt(card);
        receipt.output();

        Assert.assertEquals(12.49, receipt.getTotal(), 0.001);
        Assert.assertEquals(0.0, receipt.getAllTaxes(), 0.001);
    }
}
