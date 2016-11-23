/**
 * Created by JamesUttaro and C.K Obieyisi on 12/5/15.
 * 
 * // use FFT.cconvolve(T.CM, T.CB) alone if line 26 gives an error
 */
public class Test {

    public static void main(String[] args)
    {
        
    	
        int Dim = 1024 ; //32768 //16384 //8192
        
        Toeplitz T = new Toeplitz(Dim);
        //T.PrintMatrix();

        // Ordinary N^2
        long time1 = System.currentTimeMillis();
        T.MatrixVectorMultipication();
        long end1 = System.currentTimeMillis();
        
        System.out.println("");
        System.out.println( "Ordinary Multiplication O(N^2) Run Time: " + (end1-time1) + " milliseconds ");


        
        // FFT
        System.out.println();
        long time2 = System.currentTimeMillis();
        Complex ResultofFFT[] = FFT.cconvolve(T.CM, T.CB);
        long end2 =System.currentTimeMillis();
        System.out.println( "FFT O(NLogN) Run Time: " + (end2 - time2) + " milliseconds " );

        //FFT.show(ResultofFFT, "Result");
        
    }

}
