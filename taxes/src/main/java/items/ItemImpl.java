package items;

import java.util.Objects;

public abstract class ItemImpl implements Item{
    String name;
    double price;
    boolean isExempt;
    boolean isImport;

    public ItemImpl() {
    }

    public ItemImpl(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {        this.name = name;    }

    @Override
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {        this.price = price;    }

    @Override
    public boolean getIsExempt() {
        return isExempt;
    }
    @Override
    public void setIsExempt(boolean isExempt) {
        this.isExempt = isExempt;
    }

    @Override
    public boolean getIsImported() {
        return isImport;
    }
    @Override
    public void setIsImport(boolean isImport) {
        this.isImport = isImport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemImpl item = (ItemImpl) o;
        return Double.compare(item.price, price) == 0 && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
