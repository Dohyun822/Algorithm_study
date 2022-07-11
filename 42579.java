import java.util.*;

class Solution {
	public int[] solution(String[] genres, int[] plays) {

		HashMap<String, Integer> sumplays = new HashMap<>();
		HashMap<String, Integer> genrescount = new HashMap<>();
		HashMap<Integer, Integer> index = new HashMap<>();
		TreeMap<Integer, String> sortsumplays = new TreeMap<>(Collections.reverseOrder());
		for (int i = 0; i < genres.length; i++) {
			sumplays.put(genres[i], sumplays.getOrDefault(genres[i], 0) + plays[i]);
			genrescount.put(genres[i], genrescount.getOrDefault(genres[i], 0) + 1);
			index.put(i, plays[i]);
		}
		sumplays.forEach((key, value) -> sortsumplays.put(value, key));
		int x = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		for (String genre : sortsumplays.values()) {
			int i = 1;
			if (genrescount.get(genre) > 1) {
				i = 2;
			}
			for (int j = 0; j < i; j++) {
				int max = 0;
				int idx = 0;
				for (int k = 0; k < genres.length; k++) {
					if (index.containsKey(k) && plays[k] > max && genres[k].equals(genre)) {
						idx = k;
						max = plays[k];
					}
				}
				index.remove(idx);
				arr.add(idx);
			}
		}
		int[] answer = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			answer[i] = arr.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution a = new Solution();
		String[] arr = { "classic", "pop", "bal", "classic", "pop" };
		int[] arr2 = { 500, 100, 2000, 100, 700 };
		a.solution(arr, arr2);
	}
}