import javax.swing.text.NumberFormatter;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Matrix {
    double [][] data ;

    public Matrix(double[][] data) {
        this.data = data;
    }

    public Matrix()
    {

    }

    public void add (double[][] mas)
    {
        data = mas;
    }

    public boolean checkSimmetric()
    {
        Matrix m2 = this.flip();

        return Arrays.deepEquals(data,m2.data);
    }

    public Matrix flip ()
    {
        double [][] reversed =new double[data[0].length][data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                reversed[j][i] = data[i][j];
            }
        }
        return new Matrix(reversed);
    }

    public Matrix inverse()
    {
        int N = data.length;
        double [][] A = data;
        double temp;

        double [][] E = new double[N][N];


        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
            {
                E[i][j] = 0d;

                if (i == j)
                    E[i][j] = 1d;
            }

        for (int k = 0; k < N; k++)
        {
            temp = A[k][k];

            for (int j = 0; j < N; j++)
            {
                A[k][j] /= temp;
                E[k][j] /= temp;
            }

            for (int i = k + 1; i < N; i++)
            {
                temp = A[i][k];

                for (int j = 0; j < N; j++)
                {
                    A[i][j] -= A[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }

        for (int k = N - 1; k > 0; k--)
        {
            for (int i = k - 1; i >= 0; i--)
            {
                temp = A[i][k];

                for (int j = 0; j < N; j++)
                {
                    A[i][j] -= A[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = E[i][j];

        return new Matrix(A);
    }

    public double getElement(int i, int j)
    {
        return data[i][j];
    }

    public int getColCount()
    {
        return data[0].length;
    }

    public int getRowCount()
    {
        return data.length;
    }

    public void setElement(int i, int j, double element)
    {
        data[i][j] = element;
    }


    public Matrix sum(Matrix m)
    {
        double[][] res = new double[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                res[i][j] = data[i][j] + m.data[i][j];
            }

        }
        return new Matrix(res);
    }
    public Matrix mult(double k)
    {
        double [][] mas = new double[data[0].length][data[0].length];
        for (int i = 0; i < data.length ; i++)
        {
            for (int j = 0; j < data[0].length; j++)
            {
                mas[i][j] = k * data[i][j];
            }
        }
        return new Matrix(mas);
    }

    public Vector mult (Vector vector)
    {
        double [] result = new double[vector.data.length];
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data[0].length; j++) {
                result[i] += data[i][j] * vector.data[j];
            }

        }
        return new Vector(result);
    }

    public Matrix mult (Matrix m)
    {
        double[][] result = new double[data.length][m.data[0].length];
        double temp;
        for(int i = 0; i < data.length; i++) {         // rows from m1
            for(int j = 0; j < m.data[0].length; j++) {     // columns from m2
                for(int k = 0; k < data[0].length; k++) { // columns from m1
                    result[i][j] += data[i][k] * m.data[k][j];
                }
            }
        }
        return new Matrix(result);
    }



    public void show ()
    {
        DecimalFormat formatter = new DecimalFormat("#0.0000");
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length ; j++) {
                System.out.print(" "+ formatter.format(data[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.print("]");
        System.out.println();
    }
}
