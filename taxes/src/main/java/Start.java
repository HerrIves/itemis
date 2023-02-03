import items.Book;
import items.CD;
import items.ChocolateBar;
import shoppingcard.ShoppingCard;
import shoppingreceipt.Receipt;

public class Start {
    public static void main(String[] args) {
        ShoppingCard card = new ShoppingCard();
        card.addItem(new Book("am westen nichts neues", 12.49));
        card.addItem(new CD("Sting", 14.99));
        card.addItem(new ChocolateBar("Snickers", 0.85));

        Receipt receipt = new Receipt(card);
        receipt.output();
    }
}