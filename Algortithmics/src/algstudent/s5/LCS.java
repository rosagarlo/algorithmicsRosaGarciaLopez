package algstudent.s5;

import java.util.Random;

public class LCS {

	CellTable[][] table; // table with local values
	String str1; // 1st string
	String str2; // 2nd string
	String result; // result string
	int size1; // str1 size
	int size2; // str2 size

	/**
	 * Constructor
	 * 
	 * @param s1 1st string to compare
	 * @param s2 2nd string to compare
	 */
	public LCS(String s1, String s2) {
		str1 = "*" + s1; // str1. 1st column is headed with asterisk
		str2 = "*" + s2; // str2. 1st row is headed with asterisk
		System.out.println("String1: " + str1);
		System.out.println("String2: " + str2);
		size1 = str1.length();
		size2 = str2.length();
		result = "";
		table = new CellTable[size1][size2]; // table used for dynamic
												// programming
	}

	/**
	 * Constructor used to measure times
	 * 
	 * @param n size for the strings that are generated randomly
	 */
	public LCS(int n) {
		str1 = "*" + this.genRandomSeq(n);
		str2 = "*" + this.genRandomSeq(n);
		size1 = str1.length();
		size2 = str2.length();
		result = "";
		table = new CellTable[size1][size2]; // table used for dynamic
												// programming para guardar
												// todos los valores de la tabla
												// dinámica
	}

	/**
	 * Generates a random sequence
	 * 
	 * @param n sequence size
	 * @return random sequence, sting of characters
	 */
	private String genRandomSeq(int n) {
		char[] dna_elements = { 'A', 'C', 'G', 'T' };
		String result = "";
		Random r = new Random();
		for (int i = 0; i < n; i++)
			result += dna_elements[r.nextInt(4)];
		return result;
	}

	/**
	 * Table values initialization
	 */
	public void initTable() {
		for (int j = 0; j < size2; j++)
			for (int i = 0; i < size1; i++)
				table[i][j] = new CellTable();
	}

	/**
	 * Print the table with the results
	 */
	public void printTable() {
		System.out.printf("%11s", "*");
		for (int i = 0; i < size1; i++)
			System.out.printf("%11s", str1.substring(i, i + 1)); // chars str1
																	// (horizontal)
		System.out.println();

		for (int j = 0; j < size2; j++) {
			System.out.printf("%11s", str2.substring(j, j + 1)); // chars str2
																	// (vertical)
			for (int i = 0; i < size1; i++)
				System.out.printf("%4d(%2d,%2d)", table[i][j].value,
						table[i][j].iPrev, table[i][j].jPrev); // table values
			System.out.println();
		}
	}

	/**
	 * Print current MSC result
	 */
	public void printLongestSubseq() {
		System.out.println(result);
	}

	public class CellTable {
		public int value; // value for dynamic programming
		public int iPrev; // "pointer" to string 1 character used to compute
							// value
		public int jPrev; // "pointer" to string 2 character used to compute
							// value
	}

	/**
	 * Fill table values for dynamic programming
	 */
	public void fillTable() {
		// fill dynamic programming table with a cell (value, iPrev and jPrev)
		// for each entry
		for (int i = 1; i < size1; i++) {
			for (int j = 1; j < size2; j++) {
				int l1 = table[i][j - 1].value; 
				int l2 = table[i - 1][j].value;
				int l3 = table[i - 1][j - 1].value;
				int newValue = 0, iprev = 0, jprev = 0;
				
				l3 += str1.charAt(i) == str2.charAt(j) ? 1 : 0;
				int max = longest(l1, l2, l3);
				switch (max) {
				case 1:
					iprev = i;
					jprev = j - 1;
					newValue = l1;
					break;
				case 2:
					iprev = i - 1;
					jprev = j;
					newValue = l2;
					break;
				case 3:
					iprev = i - 1;
					jprev = j - 1;
					newValue = l3;
					break;
				}

				table[i][j].value = newValue;
				table[i][j].iPrev = iprev;
				table[i][j].jPrev = jprev;
			}
		}
	}

	/**
	 * Get the index for the maximum of three numbers
	 * 
	 * @param num1 e.g. input L1=MSC(S1’, S2). S1’ S1 without its last char
	 * @param num2 e.g. input L1=MSC(S1, S2'). S2' S2 without its last char
	 * @param num3 e.g. input L3=MSC(S1’, S2’) or L3+1 when both current chars
	 *             are equal
	 * @return index of maximum
	 */
	private int longest(int num1, int num2, int num3) {
		// (optional): from three different values (e.g. partial MSC lengths)
		// gets index for the longest
		if (num1 >= num2)
			if (num1 >= num3)
				return 1;
			else
				return 3;
		if (num2 > num3)
			return 2;
		return 3;
	}

	/**
	 * Find the MSC from the table (dynamic programming)
	 * 
	 * @param v if True verbose mode activated (To show the path trough the
	 *          different cells)
	 */
	public void findLongestSubseq(boolean v) {
		// After the table is filled, from table last element traces the MSC
		// found
		int i = size1 - 1;
		int j = size2 - 1;
		while (table[i][j].value != 0) {
			if (table[i][j].value != table[table[i][j].iPrev][table[i][j].jPrev].value)
				result += str1.toCharArray()[i];
			int aux = i;
			i = table[aux][j].iPrev;
			j = table[aux][j].jPrev;
		}
		if (v)
			System.out.println(result.toString());
	}

}
