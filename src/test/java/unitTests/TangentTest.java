package unitTests;
import org.example.trigonomethric.Tangent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TangentTest {

    private final Tangent tan = new Tangent();
    private final double EPS = 1e-6;

    @Test
    void zeroInputTest() {
        assertEquals(0.0, tan.calculate(0.0, EPS), 1e-6);
    }

    @Test
    void piDiv4InputTest() {
        assertEquals(1.0, tan.calculate(Math.PI / 4, EPS), 1e-6);
    }

    @Test
    void minusPiDiv4InputTest() {
        assertEquals(-1.0, tan.calculate(-Math.PI / 4, EPS), 1e-6);
    }

    @Test
    void periodicityTest() {
        assertEquals(
                tan.calculate(Math.PI / 6, EPS),
                tan.calculate(Math.PI / 6 + Math.PI, EPS),
                1e-6
        );
    }

    @Test
    void wrongInputTest() {
        assertThrows(ArithmeticException.class,
                () -> tan.calculate(Math.PI / 2, EPS));
    }
}
