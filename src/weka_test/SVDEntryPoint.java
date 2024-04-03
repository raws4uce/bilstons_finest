package weka_test;
import weka.core.matrix.Matrix;
import weka.core.matrix.SingularValueDecomposition;

public class SVDEntryPoint {
    public static void main(String[] args) {
        // Example data in a  2D array
        double[][] data = {
            {1,  2,  3},
            {4,  5,  6},
            {7,  8,  9}
        };

        // Create a Matrix instance
        Matrix matrix = new Matrix(data);

        // Perform SVD
        SingularValueDecomposition svd = new SingularValueDecomposition(matrix);

        // Access the decomposition components
        Matrix U = svd.getU();
        Matrix S = svd.getS();
        Matrix V = svd.getV();

        // Print the decomposition components
        System.out.println("U:\n" + U);
        System.out.println("S:\n" + S);
        System.out.println("V:\n" + V);
    }
}

