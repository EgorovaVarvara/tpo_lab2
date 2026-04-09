package unitTests;
import org.example.trigonomethric.Sinus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SinusTest {

    private final Sinus sin = new Sinus();
    private final double EPS = 1e-6;

    @Test
    void zeroInputTest() {
        assertEquals(0.0, sin.calculate(0.0, EPS), 1e-6);
    }

    @Test
    void piDiv2InputTest() {
        assertEquals(1.0, sin.calculate(Math.PI / 2, EPS), 1e-6);
    }

    @Test
    void minusPiDiv2InputTest() {
        assertEquals(-1.0, sin.calculate(-Math.PI / 2, EPS), 1e-6);
    }

    @Test
    void piInputTest() {
        assertEquals(0.0, sin.calculate(Math.PI, EPS), 1e-6);
    }

    @Test
    void periodicityTest() {
        assertEquals(
                sin.calculate(Math.PI / 4, EPS),
                sin.calculate(Math.PI / 4 + 2 * Math.PI, EPS),
                1e-6
        );
    }

    @Test
    void noEpsTest() {
        assertThrows(NullPointerException.class,
                () -> sin.calculate(1.0, null));
    }
}