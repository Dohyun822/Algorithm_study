import java.util.*;

class Solution {
	public int solution(int[] nums) {
		HashMap<Integer, Integer> poket = new HashMap<>();
		for (int x : nums) {
			poket.put(x, poket.getOrDefault(x, 0) + 1);
		}
		if (poket.size() > nums.length / 2) {
			return nums.length / 2;
		} else {
			return poket.size();
		}

	}
}