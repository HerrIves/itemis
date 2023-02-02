package items;

public class Book implements Item{
    @Override
    public long getPrice() {
        return 0;
    }

    @Override
    public boolean isExempt() {
        return false;
    }

    @Override
    public boolean isImported() {
        return false;
    }
}
