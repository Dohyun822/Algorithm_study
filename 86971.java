class Solution {
	public int solution(int n, int[][] wires) {
		int answer = -1;
		int[] result = new int[n - 1];
		for (int i = 0; i < wires.length; i++) {
			int[][] w = new int[wires.length - 1][2];
			int t = 0;
			for (int j = 0; j < wires.length; j++) {
				if (j != i) {
					w[t][0] = wires[j][0];
					w[t][1] = wires[j][1];
					t += 1;
				}
			}
			int[] v = new int[n];
			v[wires[i][0] - 1] = 1;
			v[wires[i][1] - 1] = 2;
			while (true) {
				int count = 0;
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < w.length; k++) {
						if (w[k][0] - 1 == j) {
							if (v[j] != 0) {
								v[w[k][1] - 1] = v[j];
							} else if (v[w[k][1] - 1] != 0) {
								v[j] = v[w[k][1] - 1];
							}
						} else if (w[k][1] - 1 == j) {
							if (v[j] != 0) {
								v[w[k][0] - 1] = v[j];
							} else if (v[w[k][0] - 1] != 0) {
								v[j] = v[w[k][0] - 1];
							}
						}
					}
				}
				for (int j = 0; j < v.length; j++) {
					if (v[j] == 0) {
						count += 1;
					}
				}
				if (count == 0) {
					break;
				}
			}
			int v1 = 0;
			int v2 = 0;
			for (int j = 0; j < v.length; j++) {
				if (v[j] == 1) {
					v1 += 1;
				} else if (v[j] == 2) {
					v2 += 1;
				}
			}
			if (v1 >= v2) {
				result[i] = v1 - v2;
			} else {
				result[i] = v2 - v1;
			}
		}
		answer = n;
		for (int i = 0; i < result.length; i++) {
			if (result[i] < answer) {
				answer = result[i];
			}
		}
		return answer;
	}
}
