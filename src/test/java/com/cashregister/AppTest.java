package test.java.com.cashregister;

import main.java.com.cashregister.App;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

public class AppTest {

    @Test
    public void main_showInput_expectRuns() {
        ByteArrayInputStream in = new ByteArrayInputStream("show".getBytes());
        System.setIn(in);
        App.main(null);
    }
}
