package unitTests;
import org.example.trigonomethric.Cotangent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CotangentTest {

    private final Cotangent cot = new Cotangent();
    private final double EPS = 1e-6;

    @Test
    void standartInputTest() {
        assertEquals(1.0, cot.calculate(Math.PI / 4, EPS), 1e-6);
    }

    @Test
    void standartMinusInputTest() {
        assertEquals(-1.0, cot.calculate(-Math.PI / 4, EPS), 1e-6);
    }

    @Test
    void periodicityTest() {
        for (int i = -10; i <= 10; i++) {
            assertEquals(
                    cot.calculate(Math.PI / 3 + i * Math.PI, EPS),
                    cot.calculate(Math.PI / 3 + (i + 1) * Math.PI, EPS),
                    1e-6
            );
        }
    }

    @Test
    void zeroInputTest() {
        for (int i = -10; i <= 10; i ++) {
            int mult = i;
            assertThrows(ArithmeticException.class,
                    () -> cot.calculate(mult * Math.PI, EPS));
        }
    }

    @Test
    void wrongInputTest() {
        assertThrows(ArithmeticException.class,
                () -> cot.calculate(Math.PI, EPS));
    }
}