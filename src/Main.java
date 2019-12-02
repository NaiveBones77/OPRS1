import Jama.Matrix;

public class Main {
    public static void main(String[] args) throws Exception {

//        SymmetricMatrix matrix1 = new SymmetricMatrix(new double[][] {
//                {6.25 ,-1 , 0.5},
//                {-1 ,5  ,2.12},
//                {0.5, 2.12, 3.6}
//        });
//        Matrix inversedMatrix1 = matrix1.inverse();
//        inversedMatrix1.show();
        Matrix matrix = new Matrix(new double[][]{{1,2,3},
                {3,2,1},
                {1,1,1}});
        matrix = matrix.times(3);

        int a = matrix.getRowDimension();
        a =matrix.getColumnDimension();
        Matrix vec = new Matrix(new double[][] {{1,2,3}});
        vec = vec.times(matrix);
        double d = vec.get(0,0);
        System.out.println(matrix);

    }

}
