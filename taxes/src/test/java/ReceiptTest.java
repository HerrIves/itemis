import org.junit.Assert;
import org.junit.Test;

public class ReceiptTest {

    @Test
    public void receiptOutShouldBeEqualToInput(){
        Item item = new Item();
        Assert.assertEquals(0, Receipt.outTaxesForEachItem(item), 0.001);
    }
}
