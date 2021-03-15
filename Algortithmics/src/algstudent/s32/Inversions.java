package algstudent.s32;

import java.util.Arrays;
import java.util.List;

public class Inversions {

	private Integer[] ranking;

	public Inversions(List<Integer> ranking) {
		if (ranking != null) {
			this.ranking = new Integer[ranking.size()];
			this.ranking = ranking.toArray(this.ranking);
		}
	}

	public String start() {
		// a = b^k => a = 2; b = 2; k = 1
		return mergesortAndCount(ranking, 0, ranking.length - 1) + "";
	}

	private int mergesortAndCount(Integer[] ranking, int left, int right) {
		int count = 0;
		if (right > left) {
			// Index of the element in the middle
			int midPoint = (left + right) / 2;
			// Sort the left side of the array
			count += mergesortAndCount(ranking, left, midPoint);
			// Sort the right side of the array
			count += mergesortAndCount(ranking, midPoint + 1, right);
			// Combine both parts
			count += combine(ranking, left, midPoint, right);
		}
		return count;
	}

	private int combine(Integer[] list, int left, int mid, int right) {
		int i = 0;
		int j = 0;
		int k = left;
		int count = 0;
  
		// Left subarray
        Integer[] leftHalf = Arrays.copyOfRange(list, left, mid + 1);
 
        // Right subarray
        Integer[] rightHalf = Arrays.copyOfRange(list, mid + 1, right + 1);
        
        while (i < leftHalf.length && j < rightHalf.length) { 
        	if (leftHalf[i] <= rightHalf[j])
        		list[k++] = leftHalf[i++];
            else {
            	list[k++] = rightHalf[j++];
                count += (mid + 1) - (left + i);
            }
        } 
        
        while (i < leftHalf.length)
        	list[k++] = leftHalf[i++];
        
        while (j < rightHalf.length)
        	list[k++] = rightHalf[j++];
		return count;
	}
}
