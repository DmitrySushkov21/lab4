import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


class TestsMatrix {
    @Test
    public void SuccessCalcDetTest() {
        double[][] matrix = {
                {11, 10, 9},
                {42, 3, 4},
                {41, 12, 22}
        };
        assertEquals(-3973.0, Matrix.calculateDeterminant(matrix));
    }

    @Test
    public void ZeroDetTest() {
        double[][] matrix = {
                {0, 0, 0},
                {1, 2, 3},
                {4, 5, 6}
        };
        assertEquals(0, Matrix.calculateDeterminant(matrix));
    }

    @Test
    public void Matrix1x1DetTest() {
        double[][] matrix = {
                {33},
        };
        assertEquals(33, Matrix.calculateDeterminant(matrix));
    }

    @Test
    public void Matrix2x2DetTest() {
        double[][] matrix = {
                {33, 44},
                {66, 55},
        };
        assertEquals(-1089, Matrix.calculateDeterminant(matrix));
    }

    @Test
    public void MultiplyMatrixOnVectorTest() {
        double[][] matrix = {
                {2, 4, 0},
                {-2, 1, 3},
                {-1, 0, 1}
        };
        double[] vector = {1, 2, -1};
        double[] expect = {10, -3, -2};
        assertArrayEquals(expect, Matrix.multiplyMatrixOnVector(matrix, vector));
    }

    @Test
    public void InverseMatrixTest() {
        double[][] matrix = {
                {2, 5, 7},
                {6, 3, 4},
                {5, -2, -3}
        };
        double[][] expect = {
                {1, -1, 1},
                {-38, 41, -34},
                {27, -29, 24}
        };
        assertArrayEquals(expect, Matrix.inverseMatrix(matrix));
    }
}