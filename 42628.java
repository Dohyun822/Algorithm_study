import java.util.*;

class Solution {
	public int[] solution(String[] operations) {
		int[] answer = { 0, 0 };
		PriorityQueue<Integer> min = new PriorityQueue();
		PriorityQueue<Integer> max = new PriorityQueue(Collections.reverseOrder());
		ArrayList<Integer> arr = new ArrayList<>();
		for (String x : operations) {
			if (x.charAt(0) == 'I') {
				arr.add(Integer.parseInt(x.substring(2)));
			} else if (x.charAt(0) == 'D' && x.charAt(2) == '1' && arr.size() > 0) {
				arr.remove(Collections.max(arr));
			} else if (x.charAt(0) == 'D' && x.charAt(2) == '-' && arr.size() > 0) {
				arr.remove(Collections.min(arr));
			} else {
				continue;
			}
		}
		if (arr.size() == 0) {
			return answer;
		} else {
			for (int x : arr) {
				min.add(x);
				max.add(x);
			}
		}
		answer[0] = max.peek();
		answer[1] = min.peek();
		return answer;
	}

	public static void main(String args[]) {
		Solution a = new Solution();
		String[] arr = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
		a.solution(arr);
	}
}