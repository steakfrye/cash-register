package test.java.com.cashregister;

import main.java.com.cashregister.CashRegister;
import main.java.com.cashregister.Cashier;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CashierTest {
    private Cashier cashier;

    @BeforeMethod
    public void setUp() {
        CashRegister cashRegister = new CashRegister().setTwenties(1).setTens(0).setFives(3).setTwos(4).setOnes(0);
        cashier = new Cashier(cashRegister);
    }

    @Test
    public void testShow() {
        String result = cashier.show();

        assertEquals(result, "$43 1 0 3 4 0");
    }

    @Test
    public void testPut() {
        String result = cashier.put("1", "2", "3", "0", "5");

        assertEquals(result, "$103 2 2 6 4 5");
    }

    @Test(expectedExceptions = {Exception.class})
    public void testTake_moreBillsThanAvailable_ExpectException() throws Exception {
        cashier.take("1", "4", "3", "0", "10");
    }

    @Test
    public void testTake_validWithrawl_expectRegisterEmpty() throws Exception {
        String result = cashier.take("1", "0", "3", "4", "0");
        assertEquals(result, "$0 0 0 0 0 0");
    }

    @Test
    public void testChange() {
        String change = "11";
        String result = cashier.change(change);

        assertEquals(result, "0 0 1 3 0");
    }

    @Test
    public void testQuit() {
        String result = cashier.quit();

        assertEquals(result, "Bye");
    }
}