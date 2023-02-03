package items;

public interface Item {
    public String getName();
    public double getPrice();
    public boolean getIsExempt();
    public void setIsExempt(boolean isExempt);
    public boolean getIsImported();
    public void setIsImport(boolean isImport);

}
