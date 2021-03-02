package algstudent.s2;

/* This program can be used to sort n elements with 
 * a "bad" algorithm (quadratic). 
 * It is the DIRECT INSERTION */
public class Insertion extends Vector {
	public Insertion(int nElements) {
		super(nElements);
	}

	@Override
	public void sort() {
		int n = elements.length;
		for (int i = 1; i < n; ++i) {
			int key = elements[i];
			int j = i - 1;
			while (j >= 0 && elements[j] > key) {
				elements[j + 1] = elements[j];
				j--;
			}
			elements[j + 1] = key;
		}
	}

	@Override
	public String getName() {
		return "Insertion";
	}
}
