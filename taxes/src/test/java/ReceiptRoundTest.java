import org.junit.Assert;
import org.junit.Test;

public class ReceiptRoundTest {

    @Test
    public void roundTest() {
        Assert.assertEquals(3.35, Receipt.roundTaxes(3.33), 0.0001);
    }
}
