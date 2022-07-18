import java.util.*;

class Solution {
	public int solution(int[][] routes) {
		int answer = 1;
		Arrays.sort(routes, (o1, o2) -> {
			return Integer.compare(o1[1], o2[1]);
		});
		int out = routes[0][1];
		for (int i = 0; i < routes.length; i++) {
			if (routes[i][0] > out) {
				answer++;
				out = routes[i][1];
			}
		}
		return answer;
	}
}