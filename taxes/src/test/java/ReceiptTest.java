import items.Book;
import items.Item;
import org.junit.Assert;
import org.junit.Test;

public class ReceiptTest {

    @Test
    public void receiptOutShouldBeEqualToInput(){
        Item item = new Book();
        item.setPrice(12.49);
        item.setIsExempt(true);
        item.setIsImport(false);

        Assert.assertEquals(12.49, item.getPrice()+Receipt.taxesOutForItem(item), 0.001);
    }
}
