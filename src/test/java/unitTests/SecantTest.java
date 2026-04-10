package unitTests;
import org.example.trigonomethric.Secant;
import org.junit.jupiter.api.MethodDescriptor;
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
        for (int i = -10; i <= 10; i++){
            assertEquals(sec.calculate(Math.PI / 6 + i * Math.PI, EPS),
                    sec.calculate(Math.PI / 6 + (i + 2) * Math.PI, EPS),
                    1e-6);
        }
    }

    @Test
    void wrongInputTest() {
        for (int i = -10; i <= 10; i++) {
            int mult = i;
            assertThrows(ArithmeticException.class,
                    () -> sec.calculate((2 * mult - 1) * Math.PI / 2, EPS));
        }
    }
}
