package input;

import items.Book;
import items.Item;
import items.UnknownItem;
import org.junit.Assert;
import org.junit.Test;
import shoppingcard.ShoppingCard;

import java.util.Map;
import java.util.Optional;


public class inputTest {


    @Test
    public void inputTest(){
        Item item = new UnknownItem();
        item.setName("imported test book");
        item.setPrice(12.49);
        item.setIsImport(true);
        item.setIsExempt(true);

        ShoppingCard card = new Input().proceed("1 imported test book at 12.49");

        Optional<Map.Entry<Item, Integer>> itemIntegerEntry = card.getBasked().entrySet().stream().findAny();
        Item cardItem = itemIntegerEntry.get().getKey();
        Integer cardQuantity = itemIntegerEntry.get().getValue();

        Assert.assertEquals(item, cardItem);
        Assert.assertEquals(1, cardQuantity.intValue());
        Assert.assertEquals(item.getName(), cardItem.getName());
        Assert.assertEquals(item.getPrice(), cardItem.getPrice(), 0.001);
        Assert.assertEquals(item.getIsImported(), cardItem.getIsImported());
        Assert.assertEquals(item.getIsExempt(), cardItem.getIsExempt());

    }

    @Test
    public void processNameTest(){
        Input input = new Input();
        input.inputStrLine = "2 imported test book at 12.49";
        input.processName();

        Assert.assertEquals("imported test book", input.getName());
    }

    @Test
    public void processQuantityTest(){
        Input input = new Input();
        input.inputStrLine = "2 imported test book at 12.49";
        input.processQuantity();

        Assert.assertEquals(2, input.getQuantity());
    }

    @Test
    public void processPriceTest(){
        Input input = new Input();
        input.inputStrLine = "2 imported test book at 12.49";
        input.processPrice();

        Assert.assertEquals(12.49, input.getPrice(), 0.001);
    }

    @Test
    public void processImport(){
        Input input = new Input();
        input.inputStrLine = "2 imported test book at 12.49";
        input.processImport();

        Assert.assertEquals(true, input.isImport());
    }

    @Test
    public void processExemptTest(){
        Input input = new Input();
        input.inputStrLine = "2 imported test book at 12.49";
        input.processExemptWithChadGTP();

        Assert.assertEquals(true, input.isExempt());
    }
}
