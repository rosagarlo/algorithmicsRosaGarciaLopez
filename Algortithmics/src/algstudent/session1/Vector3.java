package algstudent.session1;

public class Vector3 {

	public static void main(String arg[]) {
		// Reading input arguments
		int n_step = (int) (1e6 * Integer.parseInt(arg[0])); // Step size in M
																// (1^6) of the
																// problem in
																// the first
																// argument
		int n_min = (int) (1e6 * Integer.parseInt(arg[1])); // Maximum size in M
															// (1^6) of the
															// problem in the
															// second argument
		int n_max = (int) (1e6 * Integer.parseInt(arg[2])); // Maximum size in M
															// (1^6) of the
															// problem in the
															// third argument
		int[] v;
		int sum;
		long tic, finalTime;
		for (int i = n_min; i <= n_max; i += n_step) {
			v = new int[i];
			Vector1.fillIn(v);
			tic = System.currentTimeMillis();
			sum = Vector1.sum(v);
			finalTime = System.currentTimeMillis() - tic;
			System.out.println("The sum of elements is: " + sum);
			System.out.println(
					"The elapsed time is: " + finalTime + "milliseconds");
		}
	}
}
