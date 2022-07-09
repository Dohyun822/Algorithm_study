import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		HashMap<Integer, String> map = new HashMap<>();
		
		Arrays.sort(phone_book);
		String num = null;
		for(String number : phone_book) {
			if(num == null) {
				num = number;
			}
			else if (num.startsWith(number)||number.startsWith(num)) {
				return false;
			}
			num = number;
		}
		return answer;
		
	}
}