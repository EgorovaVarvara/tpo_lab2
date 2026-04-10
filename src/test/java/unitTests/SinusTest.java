package unitTests;

import org.example.trigonomethric.Sinus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinusTest {

    private final Sinus sin = new Sinus();
    private final double EPS = 1e-6;

    @Test
    void zeroInputTest() {
        for (int i = -10; i <= 10; i++) {
            assertEquals(0.0, sin.calculate(i * Math.PI, EPS), 1e-6);
        }
    }

    @Test
    void piDiv2InputTest() {
        for (int i = -10; i <= 10; i++) {
            assertEquals(1.0, sin.calculate(Math.PI / 2 + 2 * Math.PI * i, EPS), 1e-6);
        }
    }

    @Test
    void minusPiDiv2InputTest() {
        for (int i = -10; i <= 10; i++) {
            assertEquals(-1.0, sin.calculate(-Math.PI / 2 + 2 * Math.PI * i, EPS), 1e-6);
        }
    }

    @Test
    void piInputTest() {
        assertEquals(0.0, sin.calculate(Math.PI, EPS), 1e-6);
    }

    @Test
    void periodicityTest() {
        for (int i = -10; i <= 10; i ++) {
            assertEquals(
                    sin.calculate(Math.PI / 4 + (2 * i + 2) * Math.PI, EPS),
                    sin.calculate(Math.PI / 4 + 2 * i * Math.PI, EPS),
                    1e-6
            );
        }
    }

    @Test
    void noEpsTest() {
        assertThrows(NullPointerException.class,
                () -> sin.calculate(1.0, null));
    }
}