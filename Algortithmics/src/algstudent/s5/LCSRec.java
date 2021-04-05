package algstudent.s5;

import java.util.Random;

public class LCSRec {
	
	/**
	 * Generates a random sequence
	 * @param n sequence size
	 * @return random sequence, sting of characters
	 */
	public String genRandomSeq(int n){
		char[] dna_elements = {'A', 'C', 'G', 'T'};
		String result = "";
		Random r = new Random();
		for (int i=0; i<n; i++)
			result += dna_elements[r.nextInt(4)];
		return result;
	}
	
	/**
	 * Find a MSC directly by a recursive approach 
	 */
	public String findLongestSubseq(String s1, String s2){
		if(s1.isBlank() || s2.isBlank() || s1.isEmpty() || s2.isEmpty())
			return "";
		if (s1.substring(s1.length()-1).equals(s2.substring(s2.length()-1))) {
            return findLongestSubseq(s1.substring(0, s1.length()-1), s2.substring(0, s2.length()-1))
                    + s1.substring(s1.length()-1);
        } else {
        	String l1 = findLongestSubseq(s1.substring(0, s1.length()-1), s2);
        	String l2 = findLongestSubseq(s1, s2.substring(0, s2.length()-1));
            if (l1.length() > l2.length()) {
                return l1;
            } else {
                return l2;
            }
        }
	}
	
	/**
	 * Get the index for the longest of three strings
	 * @param l1 e.g. input L1=MSC(S1�, S2). S1� S1 without its last char
	 * @param l2 e.g. input L1=MSC(S1, S2'). S2' S2 without its last char
	 * @param l3 e.g. input L3=MSC(S1�, S2�) or L3+1 when both current chars are equal
	 * @return index of the longest string
	 */
	@SuppressWarnings("unused")
	private int longest(String l1, String l2, String l3) {
		return -1;
	}

}
