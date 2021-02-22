package algstudent.session1_1;

import algstudent.session0.MatrixOperations;

public class MatrixOperationsTimes {
	
	public static void main(String arg[]) {
		// Reading input arguments
		int n_step = (int) (Integer.parseInt(arg[0])); 
		int n_min = 10;
		int n_max = 214748364;
		MatrixOperations v;
		int sum;
		long tic, finalTime;
		for (int i = n_min; i <= n_max; i *= n_step) {
			v = new MatrixOperations(10000,0,10);
			tic = System.currentTimeMillis();
			sum = v.sumDiagonal2();
			finalTime = System.currentTimeMillis() - tic;
			System.out.println("The value of i is: " + i);
			System.out.println("The value of SUM is: " + sum);
			System.out.println(
					"The elapsed time is: " + finalTime + "milliseconds");
		}
	}
}
