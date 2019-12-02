import java.text.DecimalFormat;

public class Vector
{
    double[] data;

    public void add(double [] mas)
    {
        data = mas;
    }

    public void add(double el)
    {
        data[getLength()] = el;
    }

    public double getElement(int index)
    {
        return data[index];
    }

    public int getLength()
    {
        return data.length;
    }

    public void setElement(int index, double param)
    {
        data[index]=param;
    }

    public Vector(double[] mas)
    {
        data = mas;
    }

    public Vector()
    {

    }

    public double getMagnitude()
    {
        double d = 0;
        for (double item:
             this.data)
        {
            d+= Math.pow(item, 2);
        }
        return Math.sqrt(d);
    }

    public Vector sum(Vector k)
    {
        double [] res = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            res[i] = data[i] + k.data[i];
        }
        return new Vector(res);
    }

    public Vector mult(double k) throws Exception
    {
        double [] result = new double[data.length];
        try {

            for (int i = 0; i < data.length; i++) {
                result[i] = k * data[i];
            }
        }
        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return new Vector(result);
    }

    public double mult(Vector vector) throws  Exception
    {
        double result=0;
        try {

            for (int i = 0; i < data.length ; i++)
            {
                result += data[i] * vector.getElement(i);
            }

        } catch (Exception e) {
            System.out.println("Wrong dimensional");
            return 0;
        }

        return result;

    }

    public Vector crossProduct(Vector vector)
    {
        double [] result = new double[data.length];
        for (int i = 0; i < data.length ; i++)
        {
            result[i] = data[i] * vector.getElement(i);
        }
        return new Vector(result);
    }

    public void mult (double [][] matrix) throws Exception
    {
        double [][] result = new double[matrix[0].length][data.length];
        try {
            for (int i = 0; i < matrix[0].length ; i++)
            {
                for (int j = 0 ; j < this.data.length ; i++ )
                {
                    result[i][j] = matrix[i][j] * this.data[j];
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
            System.out.println("Wrong dimensional");
        }

    }
    public void show()
    {
        DecimalFormat formatter = new DecimalFormat("#0.0000");
        System.out.print("[");
        for (int i = 0; i < data.length; i++)
        {
            System.out.print(" " + data[i] + " ");
        }
        System.out.print("]");
    }
}
