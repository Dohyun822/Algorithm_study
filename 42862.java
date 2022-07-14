import java.util.*;

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {

		ArrayList<Integer> lostArr = new ArrayList<>();
		ArrayList<Integer> reserveArr = new ArrayList<>();
		Arrays.sort(lost);
		Arrays.sort(reserve);
		for (int x : lost) {
			lostArr.add(x);
		}
		for(int x : reserve) {
			reserveArr.add(x);
		}
		for (int x : reserveArr) {
			if (lostArr.contains(x)) {
				lostArr.remove(Integer.valueOf(x));
				reserveArr.remove(Integer.valueOf(x));
			}
		}
		for(int x: reserveArr) {
			if (lostArr.contains(x - 1)) {
				lostArr.remove(Integer.valueOf(x - 1));
			} else if (lostArr.contains(x + 1)) {
				lostArr.remove(Integer.valueOf(x + 1));
			}
		}
		int answer = n - lostArr.size();
		return answer;
	}

	public static void main(String args[]) {
		Solution x = new Solution();
		int[] lost = {1};
		int[] reserve = {1};
		x.solution(5, lost, reserve);
	}
}