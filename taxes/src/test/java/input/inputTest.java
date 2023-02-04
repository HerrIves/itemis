package input;

import items.Book;
import org.junit.Assert;
import org.junit.Test;

public class inputTest {
    @Test
    public void inputTest(){
        Book testBook = new Book("also spracht zaratustra", 12.49);
        testBook.setIsImport(true);
        testBook.setIsExempt(true);

        String input = "1 imported book at 12.49";

        Assert.assertEquals(testBook, Input.inputLine(input));
    }
}
