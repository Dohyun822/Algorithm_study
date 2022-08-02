import java.util.*;

class Solution {
	class Node {
		String departure;
		String arrival;

		Node(String departure, String arrival) {
			this.departure = departure;
			this.arrival = arrival;
		}
	}

	public String[] solution(String[][] tickets) {
		String[] answer = new String[tickets.length + 1];
		answer[0] = "ICN";
		boolean visited[] = new boolean[tickets.length];
		Arrays.sort(tickets, new Comparator<String[]>() {
			public int compare(String[] o1, String[] o2) {
				return o1[1].compareTo(o2[1]);
			}
		});
		Stack<Node> s = new Stack<>();
		int find = 0;
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i][0].equals("ICN")) {
				find = i;
				break;
			}
		}
		s.push(new Node(tickets[find][0], tickets[find][1]));
		visited[find] = true;
		int idx = 1;
		while (!s.isEmpty()) {
			Node cur = s.pop();
			answer[idx++] = cur.arrival;
			for (int i = 0; i < tickets.length; i++) {
				if (!visited[i] && cur.arrival.equals(tickets[i][0])) {
					visited[i] = true;
					s.push(new Node(tickets[i][0], tickets[i][1]));
					break;

				}
			}

		}

		return answer;
	}

	public static void main(String[] args) {
		Solution a = new Solution();
		String[][] arr = { { "ICN", "a" }, { "a", "b" }, { "a", "c" }, { "c", "a" }, { "b", "d" } };
		String[] arrx = a.solution(arr);
		for (String x : arrx) {
			System.out.println(x);
		}
	}
}