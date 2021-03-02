package algstudent.s11;

public class Vector3 {

	public static void main(String arg[]) {
		// Reading input arguments
		int n_step = (int) (Integer.parseInt(arg[0])); 
		int n_min = 10; 
		int n_max = Integer.MAX_VALUE; 
		int[] v;
		int sum;
		long tic, finalTime;
		for (int i = n_min; i <= n_max; i *= n_step) {
			v = new int[i];
			Vector1.fillIn(v);
			tic = System.currentTimeMillis();
			Vector1.maximum(v,v);
			finalTime = System.currentTimeMillis() - tic;
			System.out.println("The value of i is: " + i);
			System.out.println(
					"The elapsed time is: " + finalTime + "milliseconds");
		}
	}
}
