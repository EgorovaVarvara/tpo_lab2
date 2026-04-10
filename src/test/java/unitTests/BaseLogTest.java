package unitTests;
import org.example.logarithmic.BaseNLog;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseLogTest {

    Double EPS = 0.000001;

    @Test
    void powerTwoTest() {
        BaseNLog log2 = new BaseNLog(2);

        assertEquals(3.0, log2.calculate(8.0, 0.00001), 0.00001);
    }

    @Test
    void powerFiveTest() {
        BaseNLog log5 = new BaseNLog(5);

        assertEquals(2.0, log5.calculate(25.0, 0.000001), 0.00001);
    }

    @Test
    void powerTenTest() {
        BaseNLog log10 = new BaseNLog(10);

        assertEquals(2.0, log10.calculate(100.0, EPS), 0.0001);
    }

    @Test
    void shouldReturnZeroAtOne() {
        BaseNLog log2 = new BaseNLog(2);

        assertEquals(0.0, log2.calculate(1.0, EPS), EPS);
    }

    @Test
    void shouldThrowForNegativeX() {
        BaseNLog log2 = new BaseNLog(2);

        for (double i = -10.0; i < 0; i ++) {
            double x = i;
            assertThrows(ArithmeticException.class,
                    () -> log2.calculate(x, EPS));
        }
    }

    @Test
    void shouldThrowForBaseOne() {
        BaseNLog log1 = new BaseNLog(1);
        for (double i = -10.0; i <= 10; i ++) {
            double x = i;
            assertThrows(ArithmeticException.class,
                    () -> log1.calculate(x, EPS));
        }
    }
}
