package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    Bun bun = new Bun("white bun", 312F);

    @Test
    public void checkingGetBunName() {
        String actual = bun.getName();
        String expected = "white bun";
        assertEquals(expected, actual);
    }

    @Test
    public void checkingGetBunPrice() {
        float actual = bun.getPrice();
        float expected = 312F;
        assertEquals(expected, actual, 0.0001);
    }
}
