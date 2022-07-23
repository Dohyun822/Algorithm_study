import java.util.*;

class Solution {
	public int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		int len = citations.length;
		int x = 0;
		int y = 0;
		for (int i = 0; i < len; i++) {
			x = citations[i];
			y = len - i;

			if (y <= x) {
				answer = y;
				break;
			}
		}
		return answer;
	}
}