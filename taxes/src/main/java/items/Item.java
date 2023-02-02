package items;

public interface Item {
    public String getName();
    public void setName(String name);
    public double getPrice();
    public void setPrice(double price);
    public boolean getIsExempt();
    public void setIsExempt(boolean isExempt);
    public boolean getIsImported();
    public void setIsImport(boolean isImport);

}
