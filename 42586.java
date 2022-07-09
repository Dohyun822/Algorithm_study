import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {

		ArrayList<Integer> answerlist = new ArrayList<>();

		Queue<Integer> queue = new LinkedList<>();
		for (int x : progresses) {
			queue.add(x);
		}
		int day = 1;
		int index = 0;
		while (queue.size() > 0) {
			int count = 0;
			while (queue.peek() + (day * speeds[index]) >= 100) {
				count++;
				queue.remove();
				if (queue.size() == 0) {
					break;
				}
				index++;
			}
			day++;
			if (count != 0) {
				answerlist.add(count);
			}

		}

		int[] answer = new int[answerlist.size()];
		int size = 0;
		for (int temp : answerlist) {
			answer[size++] = temp;
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution x = new Solution();
		int[] arr = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		x.solution(arr, speeds);
	}
}