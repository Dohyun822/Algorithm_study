import java.util.*;

class Solution {
	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int left = 0;
		int right = people.length - 1;
		while (true) {
			if (left == right) {
				answer++;
				break;
			} else if (people[left] + people[right] <= limit) {
				left++;
				right--;
				answer++;
				if (left > right) {
					break;
				}

			} else {
				right--;
				answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution a = new Solution();
		int[] arr = { 70, 80, 50, 50 };
		int limit = 100;
		a.solution(arr, limit);
	}
}