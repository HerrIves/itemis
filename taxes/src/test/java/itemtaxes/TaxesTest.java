package itemtaxes;

import items.Book;
import items.CD;
import items.ImportedBottle;
import org.junit.Assert;
import org.junit.Test;

public class TaxesTest {

    @Test
    public void taxesForBookTest(){
        Book book = new Book("am westen nichts neues", 12.49);

        Assert.assertEquals(12.49, book.getPrice()+ Taxes.taxesOutForItem(book), 0.001);
    }

    @Test
    public void taxesForCDTest(){
        CD cd = new CD("sting shape of my heart", 14.99);

        System.out.println(cd.getPrice());
        System.out.println(Taxes.taxesOutForItem(cd));
        System.out.println(cd.getPrice()+Taxes.taxesOutForItem(cd));

        Assert.assertEquals(16.49, cd.getPrice()+ Taxes.taxesOutForItem(cd), 0.001);
    }

    @Test
    public void taxesForImportedBottleTest(){
        ImportedBottle bottle = new ImportedBottle("chanel no 5", 47.50);


        Assert.assertEquals(54.65, bottle.getPrice()+ Taxes.taxesOutForItem(bottle), 0.001);
    }

}
