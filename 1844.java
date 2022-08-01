import java.util.*;

class xy {
	int x;
	int y;

	xy(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Solution {
	private static int[][] dr = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

	public static int solution(int[][] maps) {
		int answer = 0;
		Queue<xy> q = new LinkedList<xy>();
		q.add(new xy(0, 0));
		int[][] copy = new int[maps.length][maps[0].length];
		copy[0][0] = 1;
		while (!q.isEmpty()) {
			xy cur = q.poll();

			for (int i = 0; i < dr.length; i++) {
				int nextX = cur.x + dr[i][0];
				int nextY = cur.y + dr[i][1];
				if (nextX < 0 || nextY < 0 || nextX >= maps.length || nextY >= maps[0].length) {
					continue;
				}
				if (maps[nextX][nextY] == 0) {
					continue;
				}
				if (copy[nextX][nextY] == 0) {
					q.offer(new xy(nextX, nextY));
					copy[nextX][nextY] = copy[cur.x][cur.y] + 1;
				}
			}
		}
		answer = copy[maps.length - 1][maps[0].length - 1];
		if (answer == 0) {
			answer = -1;
		}
		return answer;
	}
}