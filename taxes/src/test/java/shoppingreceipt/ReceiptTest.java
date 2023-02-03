package shoppingreceipt;

import org.junit.Test;
import shoppingcard.ShoppingCard;

public class ReceiptTest {

    @Test
    public void receiptOutputTest(){
        Receipt receipt = new Receipt(ShoppingCard card);
        receipt.output();
    }
}
