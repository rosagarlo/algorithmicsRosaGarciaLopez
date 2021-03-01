package algstudent.session2;

/* This program can be used to sort n elements with 
 * a "bad" algorithm (quadratic). 
 * It is the SELECTION */
public class Selection extends Vector {
	public Selection(int nElements) {
		super(nElements);
	}

	@Override
	public void sort() {
		int n = elements.length;
		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (elements[j] < elements[min_idx])
					min_idx = j;
			}
			super.interchange(min_idx, i);
		}
	}

	@Override
	public String getName() {
		return "Selection";
	}
}
