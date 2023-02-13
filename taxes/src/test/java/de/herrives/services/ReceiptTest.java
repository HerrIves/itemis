package de.herrives.services;

import de.herrives.models.items.Item;
import de.herrives.models.items.UnknownItem;
import org.junit.Assert;
import org.junit.Test;
import de.herrives.models.ShoppingCard;

public class ReceiptTest {

    @Test
    public void receiptOutputTest(){
        ShoppingCard card = new ShoppingCard();
//        card.addItem(new Book("am westen nichts neues", 12.49));
        Item item = new UnknownItem("book am westen nichts neues", 12.49);
        item.setIsExempt(true);

        card.addItem(item);

        ReceiptService receipt = new ReceiptService(card);
        receipt.output();

        Assert.assertEquals(12.49, receipt.getTotal(), 0.001);
        Assert.assertEquals(0.0, receipt.getAllTaxes(), 0.001);
    }
}
