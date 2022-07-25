import java.util.*;

class Solution {
	public int solution(String word) {
		int answer = 0;

		int len = word.length();
		for (int i = 0; i < len; i++) {
			char x = word.charAt(i);
			int cnt = 0;
			if (x == 'A') {
				cnt = 0;
			}
			if (x == 'E') {
				cnt = 1;
			}
			if (x == 'I') {
				cnt = 2;
			}
			if (x == 'O') {
				cnt = 3;
			}
			if (x == 'U') {
				cnt = 4;
			}
			if (i == 4)
				answer += cnt + 1;
			if (i == 3)
				answer += cnt * 6 + 1;
			if (i == 2)
				answer += cnt * (6 * 5 + 1) + 1;
			if (i == 1)
				answer += cnt * (31 * 5 + 1) + 1;
			if (i == 0)
				answer += cnt * ((31 * 5 + 1) * 5 + 1) + 1;
		}
		return answer;
	}
}