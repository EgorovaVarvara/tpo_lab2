package unitTests;

import org.example.trigonomethric.Cosine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CosineTest {

    private final Cosine cos = new Cosine();
    private final double EPS = 1e-6;

    @Test
    void zeroInputTest() {
        assertEquals(1.0, cos.calculate(0.0, EPS), 1e-6);
    }

    @Test
    void piDiv2InputTest() {
        assertEquals(0.0, cos.calculate(Math.PI / 2, EPS), 1e-6);
    }

    @Test
    void piInputTest() {
        assertEquals(-1.0, cos.calculate(Math.PI, EPS), 1e-6);
    }

    @Test
    void piDiv3InputTest() {
        assertEquals(0.5, cos.calculate(Math.PI / 3, EPS), 1e-6);
    }

    @Test
    void periodicityTest() {
        for (int i = -10; i <= 10; i ++) {
            assertEquals(
                    cos.calculate(Math.PI / 4 + (2 * i + 2) * Math.PI, EPS),
                    cos.calculate(Math.PI / 4 + 2 * i * Math.PI, EPS),
                    1e-6
            );
        }
    }

    @Test
    void smallInputTest() {
        assertEquals(1.0, cos.calculate(1e-8, EPS), 1e-6);
    }

    @Test
    void noEpsTest() {
        assertThrows(NullPointerException.class,
                () -> cos.calculate(1.0, null));
    }
}