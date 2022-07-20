import java.util.*;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < commands.length; i++) {
			arr.clear();
			int x = commands[i][0] - 1;
			int y = commands[i][1];
			int z = commands[i][2] - 1;
			for (int j = x; j < y; j++) {
				arr.add(array[j]);
			}
			Collections.sort(arr);
			answer[i] = arr.get(z);
		}
		return answer;
	}
}