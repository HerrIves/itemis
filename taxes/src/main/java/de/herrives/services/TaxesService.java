package de.herrives.services;

import de.herrives.config.TaxesConfig;
import de.herrives.models.items.Item;


public class TaxesService {
    public static double taxesOutForItem(Item item){
        double taxes = 0;
        if ( ! item.getIsExempt()) taxes += item.getPrice() * TaxesConfig.getBasicTax();
        if (item.getIsImported())  taxes += item.getPrice() * TaxesConfig.getImportTax();

        return roundTaxes(taxes);
    }

    public static double roundTaxes(Double inputTaxes) {
        final long inputTaxesLong = Math.round(inputTaxes*100);                                         //1.75666 -> 176

        long inputTaxesLongEnding = inputTaxesLong % 10 > 5 ? 10 : inputTaxesLong % 10 > 0 ? 5 : 0;     //176     ->  6 > 5 ->  10
                                                                                                        //                      ||
                                                                                                        //                      \/
        return ((double) (inputTaxesLong / 10 * 10 + inputTaxesLongEnding)) / 100;                      //176     -> 17 -> 170+ 10 = 180 -> 1.8
    }
}
