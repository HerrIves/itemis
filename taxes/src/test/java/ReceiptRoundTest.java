import org.junit.Assert;
import org.junit.Test;

public class ReceiptRoundTest {

    @Test
    public void roundTest() {
        Assert.assertEquals(0.05, Receipt.roundTaxes(0.04));
    }
}
