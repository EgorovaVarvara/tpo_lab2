package unitTests;
import org.example.trigonomethric.Tangent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TangentTest {

    private final Tangent tan = new Tangent();
    private final double EPS = 1e-6;

    @Test
    void zeroInputTest() {
        for (int i = -10; i <= 10; i++) {
            assertEquals(0.0, tan.calculate(i * Math.PI, EPS), 1e-6);
        }
    }

    @Test
    void piDiv4InputTest() {
        for (int i = -10; i <= 10; i ++) {
            assertEquals(1.0, tan.calculate(Math.PI / 4 + i * Math.PI, EPS), 1e-6);
        }
    }

    @Test
    void minusPiDiv4InputTest() {
        for (int i = -10; i <= 10; i ++) {
            assertEquals(-1.0, tan.calculate(-Math.PI / 4 + i * Math.PI, EPS), 1e-6);
        }
    }

    @Test
    void periodicityTest() {
        for (int i = -10; i <= 10; i ++) {
            assertEquals(
                    tan.calculate(Math.PI / 6 + i * Math.PI, EPS),
                    tan.calculate(Math.PI / 6 + (i + 1) * Math.PI, EPS),
                    1e-6
            );
        }
    }

    @Test
    void wrongInputTest() {
        for (int i = -10; i <= 10; i ++) {
            int mult = i;
            assertThrows(ArithmeticException.class,
                    () -> tan.calculate((2 * mult + 1) * Math.PI / 2, EPS));
        }
    }
}
