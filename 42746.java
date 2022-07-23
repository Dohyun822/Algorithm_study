import java.util.*;

class Solution {
	public String solution(int[] numbers) {
		String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String str1, String str2) {
				for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
					if (str2.charAt(i) == str1.charAt(i))
						continue;
					return str2.charAt(i) - str1.charAt(i);
				}
				if (str1.length() > str2.length())
					return compare(str1.substring(str2.length()), str2);
				else if (str1.length() < str2.length())
					return compare(str1, str2.substring(str1.length()));
				return 0;
			}
		});
		int cnt = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0) {
				cnt++;
			}
		}
		if (cnt == numbers.length) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}
}