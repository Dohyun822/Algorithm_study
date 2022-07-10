import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int[] priorities, int location) {
		int answer = 1;
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int x : priorities) {
			queue.offer(x);
			arr.add(x);
		}
		Collections.sort(arr, Collections.reverseOrder());

		while (true) {
			int check = queue.peek();
			if (location == 0 && priority(arr, check)) {
				return answer;
			} else if (location == 0 && !priority(arr, check)) {
				queue.offer(queue.peek());
				queue.poll();
				location = priorities.length - 1;
			} else if (location != 0 && priority(arr, check)) {
				queue.offer(queue.peek());
				queue.poll();
				arr.remove(0);
				location--;
				answer++;
			} else if (location != 0 && !priority(arr, check)) {
				location--;
				queue.offer(queue.peek());
				queue.poll();
			}

		}
	}

	public boolean priority(ArrayList<Integer> arr, int check) {
		if (Collections.max(arr) > check) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution a = new Solution();
		int[] arr = { 1, 1, 9, 1, 1, 1 };
		a.solution(arr, 0);
	}
}