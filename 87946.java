import java.util.*;

class Solution {
	public int answer = 0;

	public int solution(int k, int[][] dungeons) {

		int len = dungeons.length;
		boolean[] check = new boolean[len];
		int[] need = new int[len];
		int[] use = new int[len];
		for (int i = 0; i < len; i++) {
			need[i] = dungeons[i][0];
			use[i] = dungeons[i][1];
		}
		getCnt(check, 0, k, need, use);

		return answer;
	}

	public void getCnt(boolean[] check, int cnt, int remain, int[] need, int[] use) {

		for (int i = 0; i < need.length; i++) {
			if (!check[i] && need[i] <= remain) {
				check[i] = true;
				getCnt(check, cnt + 1, remain - use[i], need, use);
				check[i] = false;
			}
		}
		answer = Math.max(answer, cnt);
	}
}