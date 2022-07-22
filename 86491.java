import java.util.*;

class Solution {
	public int solution(int[][] sizes) {
		int answer = 0;
		ArrayList<Integer> b = new ArrayList<>();
		ArrayList<Integer> s = new ArrayList<>();
		for (int i = 0; i < sizes.length; i++) {
			if (sizes[i][0] > sizes[i][1]) {
				b.add(sizes[i][0]);
				s.add(sizes[i][1]);
			} else {
				s.add(sizes[i][0]);
				b.add(sizes[i][1]);
			}
		}
		answer = Collections.max(b) * Collections.max(s);

		return answer;
	}
}