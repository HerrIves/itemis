package de.herrives.services;

import org.junit.Assert;
import org.junit.Test;

public class TaxesRoundTest {

    @Test
    public void roundTest() {
        Assert.assertEquals(3.35, TaxesService.roundTaxes(3.33), 0.0001);
    }
}
