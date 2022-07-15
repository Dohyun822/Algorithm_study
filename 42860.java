import java.util.*;

class Solution {
	public int solution(String name) {
		int answer = 0;
		int length = name.length();
		int cnt = length - 1;
		for (int i = 0; i < length; i++) {
			answer += (name.charAt(i) - 'A' > 'Z' - name.charAt(i) + 1) ? 'Z' - name.charAt(i) + 1
					: name.charAt(i) - 'A';

			int idx = i + 1;
			while (idx < length && name.charAt(idx) == 'A') {
				idx++;
			}
			cnt = Math.min(cnt, i * 2 + length - idx);
			cnt = Math.min(cnt, (length - idx) * 2 + i);
		}
		return answer + cnt;
	}
}