import items.Book;
import items.CD;
import items.ImportedBottle;
import items.Item;
import org.junit.Assert;
import org.junit.Test;

public class ReceiptTest {

    @Test
    public void taxesForBookTest(){
        Book book = new Book();
        book.setPrice(12.49);
        book.setIsExempt(true);

        Assert.assertEquals(12.49, book.getPrice()+Receipt.taxesOutForItem(book), 0.001);
    }

    @Test
    public void taxesForCDTest(){
        CD cd = new CD();
        cd.setPrice(14.99);
//        item.setIsExempt(true);

        Assert.assertEquals(16.49, cd.getPrice()+Receipt.taxesOutForItem(cd), 0.001);
    }

    @Test
    public void taxesForImportedBottleTest(){
        ImportedBottle bottle = new ImportedBottle();
        bottle.setPrice(47.50);
        bottle.setIsExempt(true);
        bottle.setIsImport(true);

        Assert.assertEquals(54.65, bottle.getPrice()+Receipt.taxesOutForItem(bottle), 0.001);
    }
}
