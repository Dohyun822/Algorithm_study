import java.util.*;

class Solution {
	public int[] solution(int brown, int yellow) {
		int total = brown + yellow;
		int x = 0;
		int y = 3;
		while (true) {
			if (total % y == 0) {
				x = total / y;
				if (2 * x + (2 * y) - 4 == brown) {
					int[] answer = { x, y };
					return answer;
				}
				y++;
			} else {
				y++;
			}
		}
	}
}