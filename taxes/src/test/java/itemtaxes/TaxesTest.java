package itemtaxes;


import items.Item;
import items.UnknownItem;
import org.junit.Assert;
import org.junit.Test;


public class TaxesTest {

    @Test
    public void taxesForBookTest(){
        Item book = new UnknownItem("book Im Westen nichts Neues", 12.49);
        book.setIsExempt(true);
        book.setIsImport(false);


        Assert.assertEquals(12.49, book.getPrice()+ Taxes.taxesOutForItem(book), 0.001);
    }

    @Test
    public void taxesForCDTest(){
        Item cd = new UnknownItem("cd sting shape of my heart", 14.99);
        cd.setIsImport(false);
        cd.setIsExempt(false);

        System.out.println(cd.getPrice());
        System.out.println(Taxes.taxesOutForItem(cd));
        System.out.println(cd.getPrice()+Taxes.taxesOutForItem(cd));

        Assert.assertEquals(16.49, cd.getPrice()+ Taxes.taxesOutForItem(cd), 0.001);
    }

    @Test
    public void taxesForImportedBottleTest(){
        Item importedBottle = new UnknownItem("chanel no 5", 47.50);
        importedBottle.setIsImport(true);
        importedBottle.setIsExempt(false);


        Assert.assertEquals(54.65, importedBottle.getPrice()+ Taxes.taxesOutForItem(importedBottle), 0.001);
    }

}
