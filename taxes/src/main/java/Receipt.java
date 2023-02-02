import items.Item;

import java.util.function.Predicate;

public class Receipt {
    public static double taxesOutForItem(Item item){
        double taxes = 0;
        if ( ! item.getIsExempt()) taxes += item.getPrice()*0.1;
        if (item.getIsImported())  taxes += item.getPrice()*0.05;



        return roundTaxes(taxes);
    }

    public static double roundTaxes(Double inputTaxes) {
        final long inputTaxesLong = Math.round(inputTaxes*100);

//      inputTaxesLongEnding = ifInputTaxesMoreThan(7) ? 10 : ifInputTaxesMoreThan(2) ? 5 : 0;
        Predicate<Integer> ifInputTaxesMoreThan = integer -> inputTaxesLong % 10 > integer;

        long inputTaxesLongEnding =
                ifInputTaxesMoreThan.test(7) ? 10 : ifInputTaxesMoreThan.test(2) ? 5  : 0;

        return ((double) (inputTaxesLong / 10 * 10 + inputTaxesLongEnding)) / 100;
    }

}
