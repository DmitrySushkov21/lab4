import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TestsLinearSystems {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void correctSolutionsTest() {
        double[][] k = {
                {1, 7, 3},
                {-4, 9, 4},
                {0, 3, 2},
        };
        double[] f = {-1, 0, 6};
        assertArrayEquals(new double[]{0, -4, 9}, LinearSystems.solveSystem(k, f));
    }

    @Test
    public void noSolutionsTest() {
        double[][] k = {
                {1, 2, 3},
                {1, 2, 3},
                {4, 5, 6}
        };
        double[] f = {9, -4, 5};
        LinearSystems.solveSystem(k, f);
        assertEquals("Cистема не имеет решений или имеет множество решений", outputStreamCaptor.toString()
                .trim());
    }
}
