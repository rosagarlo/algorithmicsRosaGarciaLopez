package algstudent.session1_2;


public class Loop5 {
	public static void loop5(int n) {
		@SuppressWarnings("unused")
		int cont = 0;
		int i = 2*n*n*n;
		while(i > 1) {
			for (int j=2; j<=2*n; j*=3) {
				cont++;
			}
			i-=4;
		}
	}
	
	public static void main(String arg[]) {
		long t1, t2;
		int nTimes = Integer.parseInt(arg[0]);
	
		for (int n=1; n<=Integer.MAX_VALUE; n*=2) {
			t1 = System.currentTimeMillis();
	 
			for (int repetitions=1; repetitions<=nTimes; repetitions++){
				loop5(n);
			} 
	 
			t2 = System.currentTimeMillis();
			System.out.println("n="+n+ "**TIME=" +(t2-t1)+ " ** nTimes=" + nTimes);
		} //for	
	} //main
} //class
