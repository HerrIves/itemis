import items.Book;
import items.Item;
import org.junit.Assert;
import org.junit.Test;

public class ReceiptTest {

    @Test
    public void receiptOutShouldBeEqualToInput(){
        Item item = new Book();
        item.setPrice(10);

        Assert.assertEquals(0, Receipt.taxesOutForItem(item), 0.001);
    }
}
