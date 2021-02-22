package algstudent.session1_2;

public class Loop5 {
	public static void loop5(int n) {
		int m = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 2; j < n; j++) {
				for (int k = 1; k < n; k++) {
					m = n;
					while (m > 1) {
						m = m / 2;
					}
				}
			}
		}
	}

	public static void main(String arg[]) {
		long t1, t2;
		int nTimes = Integer.parseInt(arg[0]);

		for (int n = 1; n <= Integer.MAX_VALUE; n *= 2) {
			t1 = System.currentTimeMillis();

			for (int repetitions = 1; repetitions <= nTimes; repetitions++) {
				loop5(n);
			}

			t2 = System.currentTimeMillis();
			System.out.println(
					"n=" + n + "**TIME=" + (t2 - t1) + " ** nTimes=" + nTimes);
		} // for
	} // main
} // class
