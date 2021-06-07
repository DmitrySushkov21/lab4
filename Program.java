import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;


public class Program {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1. Вычислить определитель");
        System.out.println("2. Вычислить обратную матрицу");
        System.out.println("3. Умножить матрицу на вектор");
        System.out.println("4. Решить систему линейных уравнений методом обратной матрицы");
        String chose = scanner.next();
        switch (chose) {
            case "1" -> {
                double[][] matrix = readUserMatrix();
                System.out.println("Определитель равен " + Matrix.calculateDeterminant(matrix));
            }
            case "2" -> {
                double[][] matrix = readUserMatrix();
                double[][] invertMatrix = Matrix.inverseMatrix(matrix);
                System.out.println("Обратная матрица:");
                for (double[] doubles : invertMatrix) {
                    for (int j = 0; j < invertMatrix[0].length; j++)
                        System.out.print(doubles[j] + " ");
                    System.out.println();
                }
            }
            case "3" -> {
                double[][] matrix = readUserMatrix();
                double[] vector = readUserVector();
                double[] solve = Matrix.multiplyMatrixOnVector(matrix, vector);
                System.out.println("Результат умножения:");
                for (double v : solve)
                    System.out.println(v);
            }
            case "4" -> {
                ArrayList<Object> system = readUserLinearSystem();
                double[][] matrix = (double[][]) system.get(0);
                double[] freeElements = (double[]) system.get(1);
                double[] solve = LinearSystems.solveSystem(matrix, freeElements);
                System.out.println("Решение системы:");
                if (solve != null)
                    for (int i = 1; i <= solve.length; i++)
                        System.out.println("X" + i + " = " + solve[i - 1]);
            }
        }
    }

    static double[][] readUserMatrix() {
        System.out.println("Введите размерность матрицы");
        int size = scanner.nextInt();
        double[][] matrix = new double[size][size];
        System.out.println("Введите матрицу");
        IntStream.range(0, size)
                .forEach(i -> IntStream.range(0, size)
                        .forEach(j -> matrix[i][j] = scanner.nextInt()));
        return matrix;
    }

    static double[] readUserVector() {
        System.out.println("Введите размер вектора");
        int size = scanner.nextInt();
        double[] vector = new double[size];
        System.out.println("Введите векторm");
        for (int i = 0; i < size; i++)
            vector[i] = scanner.nextDouble();
        return vector;
    }

    public static ArrayList<Object> readUserLinearSystem() {
        System.out.println("Введите размер системы");
        int size = scanner.nextInt();
        double[][] matrix = new double[size][size];
        double[] freeElements = new double[size];
        System.out.println("Введите коэффициенты при неизвесных и свободные члены");
        IntStream.range(0, size).forEach(i -> IntStream.range(0, size + 1).forEach(j -> {
            if (j == size)
                freeElements[i] = scanner.nextInt();
            else
                matrix[i][j] = scanner.nextInt();
        }));
        ArrayList<Object> result = new ArrayList<>();
        result.add(matrix);
        result.add(freeElements);
        return result;
    }
}

