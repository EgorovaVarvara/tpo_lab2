import java.util.Map;

import org.example.EquationSystem;
import org.example.function.AbstractFunction;
import org.example.logarithmic.BaseNLog;
import org.example.logarithmic.NatLog;
import org.example.mockData.*;
import org.example.trigonomethric.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopDownIntegrationTest {

    private static final Double EPS = 0.00001;

    private static final Double[] NEGATIVE_BRANCH_POINTS = {
            -Math.PI/4, -Math.PI/3, -2.0, -1.0, -0.5
    };

    private static final Double[] POSITIVE_BRANCH_POINTS = {
            0.1, 0.5, 2.0, 3.0, Math.PI/2
    };
    private static final Map<Double, Double> EXPECTED = Map.ofEntries(
        Map.entry(-Math.PI/4, -41.091883),
        Map.entry(-Math.PI/3, -28.5910196),
        Map.entry(-1.0, -28.018789),
        Map.entry(-2.0, 31.9060462),
        Map.entry(-0.5, -238.4063018),
        Map.entry(0.1, 35.390108),
        Map.entry(0.5, 7.267709054452761E-6),
        Map.entry(2.0, 0.54183265),
        Map.entry(3.0, 4.7333985),
        Map.entry(Math.PI/2, 0.0830988)
    );

    @Test
    void stage0_allMock() throws Exception {
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

    @Test
    void stage1_realSin() throws Exception {
        Modules m = stubs();

        AbstractFunction sin = new Sinus();

        assertBranch(
                new EquationSystem(
                        sin, m.cos, m.sec, m.tan, m.cot,
                        m.ln, m.log2, m.log5, m.log10
                ),
                NEGATIVE_BRANCH_POINTS
        );
    }

    @Test
    void stage12_realCos() throws Exception {
        Modules m = stubs();

        AbstractFunction cos = new Cosine();

        assertBranch(
                new EquationSystem(
                        m.sin, cos, m.sec, m.tan, m.cot,
                        m.ln, m.log2, m.log5, m.log10
                ),
                NEGATIVE_BRANCH_POINTS
        );
    }

    @Test
    void stage13_realSec() throws Exception {
        Modules m = stubs();

        AbstractFunction sec = new Secant();

        assertBranch(
                new EquationSystem(
                        m.sin, m.cos, sec, m.tan, m.cot,
                        m.ln, m.log2, m.log5, m.log10
                ),
                NEGATIVE_BRANCH_POINTS
        );
    }

    @Test
    void stage14_realTan() throws Exception {
        Modules m = stubs();

        AbstractFunction tan = new Tangent();

        assertBranch(
                new EquationSystem(
                        m.sin, m.cos, m.sec, tan, m.cot,
                        m.ln, m.log2, m.log5, m.log10
                ),
                NEGATIVE_BRANCH_POINTS
        );
    }

    @Test
    void stage15_realCot() throws Exception {
        Modules m = stubs();

        AbstractFunction cot = new Cotangent();

        assertBranch(
                new EquationSystem(
                        m.sin, m.cos, m.sec, m.tan, cot,
                        m.ln, m.log2, m.log5, m.log10
                ),
                NEGATIVE_BRANCH_POINTS
        );
    }

    @Test
    void stage16_realLn() throws Exception {
        Modules m = stubs();

        AbstractFunction ln = new NatLog();

        assertBranch(
                new EquationSystem(
                        m.sin, m.cos, m.sec, m.tan, m.cot,
                        ln, m.log2, m.log5, m.log10
                ),
                NEGATIVE_BRANCH_POINTS
        );
    }

    @Test
    void stage17_realLog2() throws Exception {
        Modules m = stubs();

        AbstractFunction log2 = new BaseNLog(2);

        assertBranch(
                new EquationSystem(
                        m.sin, m.cos, m.sec, m.tan, m.cot,
                        m.ln, log2, m.log5, m.log10
                ),
                NEGATIVE_BRANCH_POINTS
        );
    }

    @Test
    void stage18_realLog5() throws Exception {
        Modules m = stubs();

        AbstractFunction log5 = new BaseNLog(5);

        assertBranch(
                new EquationSystem(
                        m.sin, m.cos, m.sec, m.tan, m.cot,
                        m.ln, m.log2, log5, m.log10
                ),
                NEGATIVE_BRANCH_POINTS
        );
    }

    @Test
    void stage19_realLog10() throws Exception {
        Modules m = stubs();

        AbstractFunction log10 = new BaseNLog(10);

        assertBranch(
                new EquationSystem(
                        m.sin, m.cos, m.sec, m.tan, m.cot,
                        m.ln, m.log2, m.log5, log10
                ),
                NEGATIVE_BRANCH_POINTS
        );
    }

    @Test
    void stage2_realSinCos() throws Exception {
        Modules m = stubs();

        AbstractFunction sin = new Sinus();
        AbstractFunction cos = new Cosine();

        assertBranch(
                new EquationSystem(
                        sin, cos, m.sec, m.tan, m.cot,
                        m.ln, m.log2, m.log5, m.log10
                ),
                NEGATIVE_BRANCH_POINTS
        );
    }

    @Test
    void stage3_realSinCosSec() throws Exception {
        Modules m = stubs();

        AbstractFunction sin = new Sinus();
        AbstractFunction cos = new Cosine();
        AbstractFunction sec = new Secant();

        assertBranch(
                new EquationSystem(
                        sin, cos, sec, m.tan, m.cot,
                        m.ln, m.log2, m.log5, m.log10
                ),
                NEGATIVE_BRANCH_POINTS
        );
    }

    @Test
    void stage4_mockCotangent() throws Exception {
        Modules m = stubs();

        AbstractFunction sin = new Sinus();
        AbstractFunction cos = new Cosine();
        AbstractFunction sec = new Secant();
        AbstractFunction tan = new Tangent();

        assertBranch(
                new EquationSystem(
                        sin, cos, sec, tan, m.cot,
                        m.ln, m.log2, m.log5, m.log10
                ),
                NEGATIVE_BRANCH_POINTS
        );
    }

    @Test
    void stage5_realAllTrig() throws Exception {
        Modules m = stubs();

        AbstractFunction sin = new Sinus();
        AbstractFunction cos = new Cosine();
        AbstractFunction sec = new Secant();
        AbstractFunction tan = new Tangent();
        AbstractFunction cot = new Cotangent();

        assertBranch(
                new EquationSystem(
                        sin, cos, sec, tan, cot,
                        m.ln, m.log2, m.log5, m.log10
                ),
                NEGATIVE_BRANCH_POINTS
        );
    }

    @Test
    void stage6_realLn() throws Exception {
        Modules m = stubs();

        AbstractFunction ln = new NatLog();

        assertBranch(
                new EquationSystem(
                        m.sin, m.cos, m.sec, m.tan, m.cot,
                        ln, m.log2, m.log5, m.log10
                ),
                POSITIVE_BRANCH_POINTS
        );
    }

    @Test
    void stage7_realLnLog2() throws Exception {
        Modules m = stubs();

        AbstractFunction ln = new NatLog();
        AbstractFunction log2 = new BaseNLog(2);

        assertBranch(
                new EquationSystem(
                        m.sin, m.cos, m.sec, m.tan, m.cot,
                        ln, log2, m.log5, m.log10
                ),
                POSITIVE_BRANCH_POINTS
        );
    }

    @Test
    void stage8_realLnLog2Log5() throws Exception {
        Modules m = stubs();

        AbstractFunction ln = new NatLog();
        AbstractFunction log2 = new BaseNLog(2);
        AbstractFunction log5 = new BaseNLog(5);

        assertBranch(
                new EquationSystem(
                        m.sin, m.cos, m.sec, m.tan, m.cot,
                        ln, log2, log5, m.log10
                ),
                POSITIVE_BRANCH_POINTS
        );
    }

    @Test
    void stage9_allReal() {
        AbstractFunction sin = new Sinus();
        AbstractFunction cos = new Cosine();
        AbstractFunction sec = new Secant();
        AbstractFunction tan = new Tangent();
        AbstractFunction cot = new Cotangent();

        AbstractFunction ln = new NatLog();
        AbstractFunction log2 = new BaseNLog(2);
        AbstractFunction log5 = new BaseNLog(5);
        AbstractFunction log10 = new BaseNLog(10);

        EquationSystem system = new EquationSystem(
                sin, cos, sec, tan, cot,
                ln, log2, log5, log10
        );

        assertBranch(system, NEGATIVE_BRANCH_POINTS);
        assertBranch(system, POSITIVE_BRANCH_POINTS);
    }

    private static void assertBranch(AbstractFunction system, Double[] points) {
        for (Double point : points) {
            Double x = point;
            Double actual = system.calculate(x, EPS);
            Double expected = EXPECTED.get(point);
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
                new BaseTwoLogMock(),
                new BaseFiveLogMock(),
                new BaseTenLogMock()

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
