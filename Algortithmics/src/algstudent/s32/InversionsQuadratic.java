package algstudent.s32;

import java.util.List;

public class InversionsQuadratic {

	private List<Integer> ranking;

	public InversionsQuadratic(List<Integer> ranking) {
		this.ranking = ranking;
	}

	public String start() {
		int count = 0;
		for (int i = 0; i < ranking.size(); i++) {
			for (int j = 0; j < ranking.size(); j++) {
				if (ranking.get(i) > ranking.get(j) && i < j) {
					count++;
				}
			}
		}
		return count + "";
	}

}
