package de.herrives.itemtaxes;

import org.junit.Assert;
import org.junit.Test;

public class TaxesRoundTest {

    @Test
    public void roundTest() {
        Assert.assertEquals(3.35, Taxes.roundTaxes(3.33), 0.0001);
    }
}
