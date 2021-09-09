import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainApplicationTest {
    @Test
    public void testSayHello() {
        MainApplication main = new MainApplication();
        assertEquals(main.sayHello(), "");
    }
}
