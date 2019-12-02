public class SymmetricMatrix extends Matrix
{
    public SymmetricMatrix(double[][] data) {
        this.data = data;
    }
    @Override
    public Matrix inverse()
    {
        int len = data[0].length;
        Matrix X = new Matrix(new double[data[0].length][data[0].length]);
        Matrix L = LowerMatrix();
        for (int i = len-1; i >= 0 ; i--)
        {
            double temp;
            temp = (1 / L.data[i][i]);
            for (int k = i+1; k <= len-1; k++)
            {
                temp -= L.data[k][i] * X.data[k][i];
            }
            X.data[i][i] = (1 / L.data[i][i]) * temp;

            for (int j = i-1; j >= 0; j--)
            {
                temp =0;
                for (int k=j+1; k <= len -1 ; k++)
                {
                    temp += L.data[k][j]*X.data[k][i];
                }
                X.data[i][j] = (-1 / L.data[j][j]) * temp;
                X.data[j][i] = X.data[i][j];
            }
        }
        return X;
    }

    public Matrix LowerMatrix()
    {
        Matrix L = new Matrix(new double [data[0].length][data[0].length]);
        for (int i = 0; i < data.length; i++)
        {
            //L[i] = new double[i + 1]; //L - треугольная матрица, поэтому в i-ой строке i+1 элементов

            double temp;
            //Сначала вычисляем значения элементов слева от диагонального элемента,
            //так как эти значения используются при вычислении диагонального элемента.
            for (int j = 0; j < i; j++)
            {
                temp = 0;
                for (int k = 0; k < j; k++)
                {
                    temp += L.data[i][k] * L.data[j][k];
                }
                L.data[i][j] = (data[i][j] - temp) / L.data[j][j];
            }

            //Находим значение диагонального элемента
            temp = data[i][i];
            for (int k = 0; k < i; k++)
            {
                temp -= L.data[i][k] * L.data[i][k];
            }
            L.data[i][i] = Math.sqrt(temp);
        }

        return L;
    }

    public void setEmenent(int i, int j, double value)
    {
        this.data[i][j] = value;
        this.data[j][i] = value;
    }
}
