import java.util.*;

class Solution {
	public String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		int len = number.length() - k;
		int idx = 0;
		for (int i = 0; i < len; i++) {
			int max = 0;
			for (int j = idx; j <= i + k; j++) {
				if (max < number.charAt(j) - '0') {
					max = number.charAt(j) - '0';
					idx = j + 1;
				}
			}
			answer.append(Integer.toString(max));
		}

		return answer.toString();
	}

	public static void main(String[] args) {
		String arr = "1234";
		int x = 2;
		Solution a = new Solution();
		a.solution(arr, x);
	}
}