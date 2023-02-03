package items;

public class ChocolateBar extends ItemImpl{
    public ChocolateBar(String name, double price) {
        super(name, price);
        this.isExempt = true;
    }
}
