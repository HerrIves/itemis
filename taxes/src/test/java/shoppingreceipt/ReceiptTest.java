package shoppingreceipt;

import items.Book;
import items.CD;
import items.ChocolateBar;
import items.UnknownItem;
import org.junit.Assert;
import org.junit.Test;
import shoppingcard.ShoppingCard;

public class ReceiptTest {

    @Test
    public void receiptOutputTest(){
        ShoppingCard card = new ShoppingCard();
//        card.addItem(new Book("am westen nichts neues", 12.49));
        card.addItem(new CD("Sting", 14.99));
        card.addItem(new ChocolateBar("Snickers", 0.85));
        card.addItem(new UnknownItem("am westen nichts neues", 12.49));

        Receipt receipt = new Receipt(card);
        receipt.output();

        Assert.assertEquals(29.83, receipt.getTotal(), 0.001);
        Assert.assertEquals(1.50, receipt.getAllTaxes(), 0.001);
    }
}
