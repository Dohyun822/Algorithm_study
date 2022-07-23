import java.util.*;

class Solution {
	public ArrayList<Integer> solution(int[] answers) {
		ArrayList<Integer> answer = new ArrayList<>();
		int[] stu1 = { 1, 2, 3, 4, 5 };
		int[] stu2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] stu3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int score1 = 0, score2 = 0, score3 = 0;
		int idx1 = 0, idx2 = 0, idx3 = 0;
		for (int i = 0; i < answers.length; i++) {

			if (idx1 > stu1.length - 1) {
				idx1 = 0;
			}
			if (idx2 > stu2.length - 1) {
				idx2 = 0;
			}
			if (idx3 > stu3.length - 1) {
				idx3 = 0;
			}
			if (answers[i] == stu1[idx1]) {
				score1++;
			}
			if (answers[i] == stu2[idx2]) {
				score2++;
			}
			if (answers[i] == stu3[idx3]) {
				score3++;
			}
			idx1++;
			idx2++;
			idx3++;
		}
		int max = 0;
		if (score1 > max) {
			max = score1;
		}
		if (score2 > max) {
			max = score2;
		}
		if (score3 > max) {
			max = score3;
		}

		if (score1 >= max) {
			answer.add(1);
		}
		if (score2 >= max) {
			answer.add(2);
		}
		if (score3 >= max) {
			answer.add(3);
		}
		return answer;
	}

}