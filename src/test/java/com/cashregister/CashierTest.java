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
    public void testShow_currentTotalAndCashNumbersReturned() {
        String result = cashier.show();

        assertEquals(result, "$43 1 0 3 4 0");
    }

    @Test
    public void testPut_assortmentOfBills_totalAndBillCountReturned() {
        String result = cashier.put("1", "2", "3", "0", "5");

        assertEquals(result, "$103 2 2 6 4 5");
    }

    @Test
    public void testTake_moreBillsThanAvailable_ExpectSorry() {
        String result = cashier.take("1", "4", "3", "0", "10");
        assertEquals(result, "sorry");
    }

    @Test
    public void testTake_validWithrawl_expectRegisterEmpty() {
        String result = cashier.take("1", "0", "3", "4", "0");
        assertEquals(result, "$0 0 0 0 0 0");
    }

    @Test
    public void testChange_changeNotAvailable_expectSorry() {
        String change = "11";
        String result = cashier.change(change);

        assertEquals(result, "sorry");
    }

    @Test
    public void testChange_changeAvailable_expectReturnedChange() {
        String change = "12";
        String result = cashier.change(change);

        assertEquals(result, "0 0 2 1 0");
    }

    @Test
    public void testQuit() {
        String result = cashier.quit();

        assertEquals(result, "Bye");
    }
}