package items;


public class Book implements Item {
    String name;
    double price;
    boolean isExempt;
    boolean isImport;

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

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


}
