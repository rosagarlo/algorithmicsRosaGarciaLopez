package algstudent.session1_1;

public class Vector2 {

	public static void main(String args[]) {
		int n = Integer.parseInt(args[0]);
		int[] v = new int[n];
		long start = System.currentTimeMillis();
		Vector1.sum(v);
		long end = System.currentTimeMillis();
		long finalTime = (end - start);
		System.out.println("The time taken to execute " + n
				+ " repetitions was " + finalTime + " milliseconds");
	}
}