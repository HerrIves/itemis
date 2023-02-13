package de.herrives.services;


import de.herrives.models.items.*;

import org.junit.Assert;
import org.junit.Test;


public class TaxesServiceTest {

    @Test
    public void roundTest() {
        Assert.assertEquals(3.35, TaxesService.roundTaxes(3.33), 0.0001);
    }

    @Test
    public void taxesForBookTest(){
        Item book = new UnknownItem("book Im Westen nichts Neues", 12.49);
        book.setIsExempt(true);
        book.setIsImport(false);


        Assert.assertEquals(12.49, book.getPrice()+ TaxesService.taxesOutForItem(book), 0.001);
    }

    @Test
    public void taxesForCDTest(){
        Item cd = new UnknownItem("cd sting shape of my heart", 14.99);
        cd.setIsImport(false);
        cd.setIsExempt(false);

        System.out.println(cd.getPrice());
        System.out.println(TaxesService.taxesOutForItem(cd));
        System.out.println(cd.getPrice()+ TaxesService.taxesOutForItem(cd));

        Assert.assertEquals(16.49, cd.getPrice()+ TaxesService.taxesOutForItem(cd), 0.001);
    }

    @Test
    public void taxesForImportedBottleTest(){
        Item importedBottle = new UnknownItem("chanel no 5", 47.50);
        importedBottle.setIsImport(true);
        importedBottle.setIsExempt(false);


        Assert.assertEquals(54.65, importedBottle.getPrice()+ TaxesService.taxesOutForItem(importedBottle), 0.001);
    }

}
