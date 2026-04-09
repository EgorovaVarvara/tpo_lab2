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
        assertEquals(
                cot.calculate(Math.PI / 3, EPS),
                cot.calculate(Math.PI / 3 + Math.PI, EPS),
                1e-6
        );
    }

    @Test
    void zeroInputTest() {
        assertThrows(ArithmeticException.class,
                () -> cot.calculate(0.0, EPS));
    }

    @Test
    void wrongInputTest() {
        assertThrows(ArithmeticException.class,
                () -> cot.calculate(Math.PI, EPS));
    }
}