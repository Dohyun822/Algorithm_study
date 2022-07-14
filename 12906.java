import java.util.*;

public class Solution {
	public int[] solution(int[] arr) {
		int size = 0;

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				q.offer(arr[i]);
			} else if (arr[i - 1] == (arr[i])) {
				continue;
			} else {
				q.offer(arr[i]);
			}
		}
		size = q.size();
		int[] answer = new int[size];
		for (int i = 0; i < size; i++) {
			answer[i] = q.poll();
		}

		// [����] ��ư�� ������ ��� ���� �� �� �ֽ��ϴ�.
		System.out.println("Hello Java");

		return answer;
	}
}