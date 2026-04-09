import java.util.Map;

import org.example.EquationSystem;
import org.example.function.AbstractFunction;
import org.example.mockData.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationTest {

    private static final Double EPS = 0.00001;

    private static final Double[] NEGATIVE_BRANCH_POINTS = {
            -Math.PI/4, -Math.PI/3, -2.0, -1.0, -0.5
    };

    private static final Double[] POSITIVE_BRANCH_POINTS = {
            0.1, Math.PI/2
    };
    private static final Map<Double, Double> EXPECTED = Map.ofEntries(
        Map.entry(-Math.PI/4, -41.091883),
        Map.entry(-Math.PI/3, -28.5910196),
        Map.entry(-1.0, -28.018789),
        Map.entry(-2.0, 31.9060462),
        Map.entry(-0.5, -238.4063018),
        Map.entry(0.1, 35.390108),
        Map.entry(0.5, 7.267709),
        Map.entry(2.0, 0.54183265),
        Map.entry(3.0, 4.7333985),
        Map.entry(Math.PI/2, 0.0830988)
    );

    @Test
    void stage0_allModulesStubbed() throws Exception {
        Modules m = stubs();

        assertBranch(
                new EquationSystem(
                        m.sin, m.cos, m.sec, m.tan, m.cot,
                        m.ln, m.log2, m.log5, m.log10
                ),
                NEGATIVE_BRANCH_POINTS
        );

        assertBranch(
                new EquationSystem(
                        m.sin, m.cos, m.sec, m.tan, m.cot,
                        m.ln, m.log2, m.log5, m.log10
                ),
                POSITIVE_BRANCH_POINTS
        );
    }

    private static void assertBranch(AbstractFunction system, Double[] points) {
        for (Double point : points) {
            Double x = point;
            Double actual = system.calculate(x, EPS);
            Double expected = EXPECTED.get(point);
//            assertEquals(0.08309, result2, 0.001);
            assertEquals(expected, actual, EPS);
        }
    }

    private static Modules stubs() {
        return new Modules(
                new SinusMock(),
                new CosineMock(),
                new SecantMock(),
                new TangentMock(),
                new CotangentMock(),
                new NatLogMock(),
                new BaseFiveLogMock(),
                new BaseTenLogMock(),
                new BaseTwoLogMock()
        );
    }

    private record Modules(
            AbstractFunction sin,
            AbstractFunction cos,
            AbstractFunction sec,
            AbstractFunction tan,
            AbstractFunction cot,
            AbstractFunction ln,
            AbstractFunction log2,
            AbstractFunction log5,
            AbstractFunction log10
    ) {}
}
