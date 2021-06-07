public class LinearSystems {
    public static double[] solveSystem(double[][] matrix, double[] freeEl) {
        if (Matrix.calculateDeterminant(matrix) == 0) {
            System.out.println("Cистема не имеет решений или имеет множество решений");
            return null;
        }
        return Matrix.multiplyMatrixOnVector(Matrix.inverseMatrix(matrix), freeEl);
    }
}
