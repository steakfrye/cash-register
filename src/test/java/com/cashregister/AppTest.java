package test.java.com.cashregister;

import main.java.com.cashregister.App;
import org.testng.annotations.Test;

public class AppTest {

    @Test
    public void main_quitArgument_expectRuns() {
        String[] args = {"quit"};
        App.main(args);
    }
}
