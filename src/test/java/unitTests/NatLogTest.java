package unitTests;
import org.example.logarithmic.NatLog;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NatLogTest {

    private final NatLog ln = new NatLog();
    private final double EPS = 1e-6;

    @Test
    void shouldReturnZero() {
        assertEquals(0.0, ln.calculate(1.0, EPS), 1e-6);
    }

    @Test
    void natLogTest() {
        assertEquals(0.693147, ln.calculate(2.0, EPS), 1e-6);
    }

    @Test
    void negativeOutputTest() {
        assertEquals(-0.693147, ln.calculate(0.5, EPS), 1e-6);
    }

    @Test
    void nearOneTest() {
        assertTrue(ln.calculate(1.001, EPS) > 0);
    }

    @Test
    void nearOneLeftTest() {
        assertTrue(ln.calculate(0.999, EPS) < 0);
    }

    @Test
    void zeroInputTest() {
        assertThrows(ArithmeticException.class,
                () -> ln.calculate(0.0, EPS));
    }

    @Test
    void negativeInputTest() {
        assertThrows(ArithmeticException.class,
                () -> ln.calculate(-1.0, EPS));
    }
}
