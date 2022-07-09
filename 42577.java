import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		HashMap<Integer, String> map = new HashMap<>();
		
		for(int i = 0; i<phone_book.length; i++) {
			map.put(i, phone_book[i]);
		}
		for(int j = phone_book.length/2 -1; j < phone_book.length; j++) {
			String number = map.get(j);
			for(int i = 0; i<phone_book.length/2 + 1; i++) {
				String comp = phone_book[i];
				if(number.equals(comp)) {
					continue;
				}
				else if(comp.startsWith(number)||number.startsWith(comp)) {
					return false;
				}
			}
		}
		return answer;
		
	}
}