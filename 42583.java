import java.util.*;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int weight_sum = 0;
		int truck = 0;
		Queue<Integer> queue = new LinkedList<>();
		while (truck < truck_weights.length) {
			if (truck_weights.length == 1) {
				return bridge_length + 1;
			} else if (truck == 0) {
				queue.offer(truck_weights[truck]);
				weight_sum += truck_weights[truck++];
				answer++;
			} else if (queue.size() == bridge_length) {
				weight_sum -= queue.poll();
			} else if (weight_sum + truck_weights[truck] > weight) {
				queue.offer(0);
				answer++;
			} else {
				queue.offer(truck_weights[truck]);
				weight_sum += truck_weights[truck];
				truck++;
				answer++;
			}
		}

		return answer + bridge_length;
	}

}