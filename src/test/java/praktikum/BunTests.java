package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BunTests {

    private Bun bun;

    @Before
    public void createBun() {
        bun = new Bun("Краторная булка N-200i", 1255);
    }

    @Test
    public void getNameOfBun() {
        String actualBunName = bun.getName();
        String expectedBunName = "Краторная булка N-200i";

        assertEquals("Названия булки не соответствует ожидаемому", expectedBunName, actualBunName);
    }
    @Test
    public void getPPriceOfBun() {
        float actualBunPrice = bun.getPrice();
        float expectedBunPrice = 1255;

        assertEquals("Стоимость булки не соответствует ожидаемой", expectedBunPrice, actualBunPrice, 0);
    }
}