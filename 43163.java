import java.util.*;

class Solution {
	class Node {
		String str;
		int cnt;

		Node(String str, int cnt) {
			this.str = str;
			this.cnt = cnt;
		}
	}

	public int solution(String begin, String target, String[] words) {
		int answer = 0;
		boolean[] visited = new boolean[words.length];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(begin, 0));
		boolean check = false;
		for (String x : words) {
			if (check) {
				break;
			}
			if (x.equals(target)) {
				check = true;
			}
		}
		if (!check) {
			return 0;
		}

		while (!q.isEmpty()) {
			Node x = q.poll();
			if (x.str.equals(target)) {
				return x.cnt;
			}

			for (int i = 0; i < words.length; i++) {
				if (possible(x.str, words[i]) && !visited[i]) {
					visited[i] = true;
					q.add(new Node(words[i], x.cnt + 1));
				}
			}
		}
		return answer;
	}

	public boolean possible(String x, String y) {
		int same = x.length() - 1;
		int cnt = 0;
		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) == y.charAt(i)) {
				cnt++;
			}
		}
		if (same == cnt) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cot";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		Solution a = new Solution();
		a.solution(begin, target, words);
	}
}