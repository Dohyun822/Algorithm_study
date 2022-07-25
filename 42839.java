import java.util.*;

class Solution {
	StringBuilder sb = new StringBuilder();
	int answer = 0;
	HashSet<Integer> set = new HashSet<>();

	public int solution(String numbers) {

		int[] arr = new int[numbers.length()];
		for (int i = 0; i < numbers.length(); i++) {
			arr[i] = numbers.charAt(i) - '0';
		}
		for (int i = 1; i <= numbers.length(); i++) {
			per1(arr, 0, numbers.length(), i);
		}
		for (int x : set) {
			if (isPrime(x)) {
				answer++;
			}
		}

		return answer;
	}

	public boolean isPrime(int n) {
		if (n == 0 || n == 1) {
			return false;
		}
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public void per1(int[] arr, int depth, int n, int r) {
		if (depth == r) {
			ad(arr, r);
			set.add(Integer.parseInt(sb.toString()));
			sb.setLength(0);
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			per1(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	public void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

	public void ad(int[] arr, int r) {
		for (int i = 0; i < r; i++) {
			sb.append(arr[i]);
		}
	}

	public static void main(String[] args) {
		Solution a = new Solution();
		a.solution("17");
	}
}