import org.example.EquationSystem;
import org.example.function.AbstractFunction;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SystemIntegrationTest {

    @Mock
    private AbstractFunction sin;

    @Mock
    private AbstractFunction cos;

    @Mock
    private AbstractFunction sec;

    @Mock
    private AbstractFunction tan;

    @Mock
    private AbstractFunction cot;

    @Mock
    private AbstractFunction natLog;

    @Mock
    private AbstractFunction log2;

    @Mock
    private AbstractFunction log5;

    @Mock
    private AbstractFunction log10;

    @Test
    void onlyTrigFunctionsTest() {

        Double x = -1.0;
        Double eps = 0.00001;

        when(cos.calculate(x, eps)).thenReturn(1.0);
        when(sec.calculate(x, eps)).thenReturn(1.0);
        when(tan.calculate(x, eps)).thenReturn(1.0);
        when(cot.calculate(x, eps)).thenReturn(1.0);

        EquationSystem system = new EquationSystem(
                sin, cos, sec, tan, cot,
                natLog, log2, log5, log10
        );

        system.calculate(x, eps);

        verify(sin, times(1)).calculate(x, eps);
        verify(cos, times(2)).calculate(x, eps);
        verify(sec, times(2)).calculate(x, eps);
        verify(tan, times(1)).calculate(x, eps);
        verify(cot, times(1)).calculate(x, eps);

        verifyNoInteractions(natLog, log2, log5, log10);
    }

    @Test
    void onlyLogarifsTest() {

        Double x = 2.0;
        Double eps = 0.00001;

        when(natLog.calculate(x, eps)).thenReturn(1.0);
        when(log2.calculate(x, eps)).thenReturn(1.0);
        when(log5.calculate(x, eps)).thenReturn(1.0);
        when(log10.calculate(x, eps)).thenReturn(1.0);

        EquationSystem system = new EquationSystem(
                sin, cos, sec, tan, cot,
                natLog, log2, log5, log10
        );

        system.calculate(x, eps);

        verify(natLog, times(1)).calculate(x, eps);
        verify(log2, times(1)).calculate(x, eps);
        verify(log5, times(2)).calculate(x, eps);
        verify(log10, times(1)).calculate(x, eps);

        verifyNoInteractions(sin, cos, sec, tan, cot);
    }
}