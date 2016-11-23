/**
 * Created by JamesUttaro and C.K Obieyisi on 12/5/15.
 *
 *
 *
 */
public class Toeplitz
{

    public int Dim;
    public int R[];
    public int B[];
    public int M[][];
    
    // Inputs for FFT
    public Complex CM[]; 
    public Complex CB[];


    public Toeplitz(int Dim)
    {
        this.Dim = Dim;                // Dimension of the Toeplitz Matrix
        this.R = new int[Dim];         // Resulting Vector for CM(b)=R
        this.B = new int[(Dim)];       // Vector B of all 1's
        this.M = new int[Dim][Dim];    // the Toeplitz Matrix

        this.CB = new Complex[2*Dim]; // Vector B will be init to all ones
        this.CM = new Complex[2*Dim]; // Set of elements in the first Row and Column

        InitializeToeplitz();   // Initialize Toeplitz Matrix
        VectorB();              //Initialize Vector B to all 1's

        //Initialize Complex Polynomials
        firstRowCol();
        VectorCB();
        
    }

    public void InitializeToeplitz()
    {
        int x = 2*Dim;

        for (int i = 0; i < Dim; i++)
        {
            for (int j = 0; j < Dim; j++) {
                M[i][j] = Math.abs(x-(i-j)-Dim)+10; // Add 10 to keep the output all the outputs of the same decimal space
            }
        }

    }

    public void MatrixVectorMultipication()
    {
        for (int i = 0; i < Dim ; i++)
        {
            for(int j = 0; j < Dim; j++)
            {
                R[i] = (M[i][j] * B[j]) + R[i];
            }
        }
       // PrintVector();
    }

    public void PrintMatrix()
    {
        System.out.println("");
        System.out.println("Toeplitz Matrix");
        for (int i = 0; i < Dim ; i++) {
            for (int j = 0; j <Dim ; j++) {
                System.out.print(M[i][j]);

            }
            System.out.println("");
        }
    }

    public void PrintVector()
    {

        System.out.println("");
        System.out.println("Resultant Vector Standard multiplication");
        System.out.print("{");
        for (int i = 0; i < Dim ; i++)
        {
            System.out.print(" " + R[i]);
        }
        System.out.print(" }");
        System.out.println("");

    }

    public void VectorB()
    {
        for (int i = 0; i < Dim; i++) {
            B[i] = 1;
        }
    }

    public void VectorCB() {

        for (int i = 0; i < Dim ; i++) {
            CB[i] = new Complex((double) (1));
//            CB[i+Dim] = new Complex((double)(0));
        }

        for(int i = 0; i < Dim; i++)
        {
            CB[(Dim+i)] = new Complex((double)(0));
        }


        CB[2*Dim-1] = new Complex((double)(0));
//        System.out.println("");
//        System.out.println("CB");
//        System.out.print("{");
//        for (int i = 0; i < CB.length ; i++)
//        {
//            System.out.print(" " + CB[i]);
//        }
//        System.out.print(" }");
    }


    public void firstRowCol()
    {

        for(int i = 0 ; i < Dim ; i++)
        {
            CM[Dim-i-1] = new Complex(((double)(M[i][0])));
        }
        
        for(int i = 1; i < Dim; i++)
        {
            CM[(Dim+i)-1] = new Complex(((double)(M[0][i])));
        }
        CM[2*Dim-1]= new Complex((double)(0));

//        System.out.println("");
//        System.out.println("Distinct Value Polynomial in Complex form");
//        System.out.print("{");
//        for (int i = 0; i < CM.length ; i++)
//        {
//            System.out.print(" " + CM[i]);
//        }
//        System.out.print(" }");

    }

}
