package test.java.com.cashregister;

import main.java.com.cashregister.CashRegister;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CashRegisterTest {

    @Test
    public void getTotal_90DollarsInRegister_expectTotalToMatch() {
        CashRegister cashRegister = new CashRegister().setTwenties(4).setFives(2);
        assertEquals(90, cashRegister.getTotal());
    }
}