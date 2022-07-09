import java.util.HashMap;

class Solution {
	public int solution(String[][] clothes) {
		int answer = 0;
		int a = 1;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}
		System.out.println(map.entrySet());
		for (String x : map.keySet()) {
			a *= map.get(x)+1;
		}
		answer = a-1;
		return answer;
	}

	public static void main(String args[]) {
		String[][] arr = { { "crow", "headgear" }, { "blue", "eye" }, { "smoky", "headgear" } , { "smoky", "headgear" } };
		Solution a = new Solution();
		System.out.println(a.solution(arr));
	}
}