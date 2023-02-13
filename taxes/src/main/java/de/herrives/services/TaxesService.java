package de.herrives.services;

import de.herrives.config.TaxesConfig;
import de.herrives.models.items.Item;

import java.util.function.Predicate;

public class TaxesService {
    public static double taxesOutForItem(Item item){
        double taxes = 0;
        if ( ! item.getIsExempt()) taxes += item.getPrice() * TaxesConfig.getBasicTax();
        if (item.getIsImported())  taxes += item.getPrice() * TaxesConfig.getImportTax();

        return roundTaxes(taxes);
    }

    public static double roundTaxes(Double inputTaxes) {
        final long inputTaxesLong = Math.round(inputTaxes*100);

        Predicate<Integer> ifInputTaxesMoreThan = integer -> inputTaxesLong % 10 > integer;

        long inputTaxesLongEnding =
                ifInputTaxesMoreThan.test(5) ? 10 : ifInputTaxesMoreThan.test(0) ? 5 : 0;

        return ((double) (inputTaxesLong / 10 * 10 + inputTaxesLongEnding)) / 100;
    }
}
