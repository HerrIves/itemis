package items;


public class Book extends ItemImpl {
    public Book(String name, double price) {
        super(name, price);
        this.isExempt = true;
    }
}
