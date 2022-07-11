import java.util.*;

class Solution {
	public int solution(int[][] jobs) {
		int answer = 0;
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		Arrays.sort(jobs, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});

		int currenttime = 0;
		int count = 0;

		while (count < jobs.length || !queue.isEmpty()) {
			while (count < jobs.length && jobs[count][0] <= currenttime) {
				queue.offer(jobs[count++]);
			}
			if (queue.isEmpty()) {
				currenttime = jobs[count][0];
			} else {
				int[] task = queue.poll();

				currenttime += task[1];
				answer += currenttime - task[0];
			}
		}

		return answer / jobs.length;
	}
}
