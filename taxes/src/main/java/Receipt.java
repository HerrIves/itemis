import items.Item;

public class Receipt {
    public static double taxesOutForItem(Item item){
        double taxes = 0;
        if ( ! item.getIsExempt()) taxes += item.getPrice()*0.1;
        if (item.getIsImported())  taxes += item.getPrice()*0.05;

        return taxes;
    }
}
