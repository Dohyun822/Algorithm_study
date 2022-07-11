import java.util.*;

class Solution {
	public int[] solution(String[] genres, int[] plays) {
		int[] answer = new int[genres.length - 1];
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
				answer[x] = idx;
				x++;
			}
		}
		return answer;
	}
}