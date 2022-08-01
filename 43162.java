import java.util.*;

class Solution {
	Queue<Integer> q = new LinkedList<>();
	boolean[] visited;

	public int solution(int n, int[][] computers) {
		int answer = 0;

		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				answer++;
				bfs(computers, i, n);
			}
		}
		return answer;
	}

	public void bfs(int[][] computers, int node, int x) {
		q.add(node);
		visited[node] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int i = 0; i < x; i++) {
				if (!visited[i] && computers[curr][i] == 1) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
}