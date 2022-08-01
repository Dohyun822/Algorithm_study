import java.util.*;

class Solution {
	public int solution(int[] numbers, int target) {
		return dfs(numbers, target, 0, 0);
	}

	public int dfs(int[] numbers, int target, int idx, int num) {
		if (idx == numbers.length) {
			return num == target ? 1 : 0;

		} else {
			return dfs(numbers, target, idx + 1, num + numbers[idx])
					+ dfs(numbers, target, idx + 1, num - numbers[idx]);
		}
	}
}