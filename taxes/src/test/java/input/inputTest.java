package input;

import items.Book;
import items.Item;
import org.junit.Assert;
import org.junit.Test;

public class inputTest {
    @Test
    public void inputTest(){
        Book testBook = new Book("imported test book", 12.49);
        testBook.setIsImport(true);
        testBook.setIsExempt(true);

        String inputString = "1 imported test book at 12.49";


        Assert.assertEquals(testBook, new Input().proceed(inputString));
    }
}
