package unitTests;
import org.example.trigonomethric.Secant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SecantTest {

    private final Secant sec = new Secant();
    private final double EPS = 1e-6;

    @Test
    void zeroInputTest() {
        assertEquals(1.0, sec.calculate(0.0, EPS), 1e-6);
    }

    @Test
    void standartInputTest() {
        assertEquals(-1.0, sec.calculate(Math.PI, EPS), 1e-6);
    }

    @Test
    void piDiv3InputTest() {
        assertEquals(2.0, sec.calculate(Math.PI / 3, EPS), 1e-6);
    }

    @Test
    void periodicityTest() {
        assertEquals(
                sec.calculate(Math.PI / 6, EPS),
                sec.calculate(Math.PI / 6 + 2 * Math.PI, EPS),
                1e-6
        );
    }

    @Test
    void wrongInputTest() {
        assertThrows(ArithmeticException.class,
                () -> sec.calculate(Math.PI / 2, EPS));
    }
}
