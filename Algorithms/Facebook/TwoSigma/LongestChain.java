
public class TS_LongestChain {
	public static void main(String[] args) {
		String[] input = new String[] {"bdca", "bca", "a", "b", "ba", "bda", };
		//String[] input = new String[] {"bdac","a","dc", "ac", "dac", };
		getLongestChain(input);
	}
	
	private static int getLongestChain(String[] s) {
		if (s == null || s.length == 0) {
			return 0;
		}
		
		Arrays.sort(s, (a, b) -> {
			return a.length() - b.length();
		});
		
		int n = s.length;
		Map<String, Integer> lens = new HashMap<>();
		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			lens.put(s[i], 1);
			char[] chars = s[i].toCharArray();
			StringBuilder tmp = new StringBuilder();
			for (int j = 0; j < chars.length; j++) {
				for (int k = 0; k < chars.length; k++) {
					if (k == j) {continue; }
					tmp.append(chars[k]);
				}
				String prev = tmp.toString();
				if (lens.containsKey(prev)) {
					lens.put(s[i], Math.max(lens.get(prev) + 1, lens.get(s[i])));
				} 
				tmp.setLength(0);
			}
			maxLen = Math.max(maxLen, lens.get(s[i]));
			System.out.println(s[i]+","+lens.get(s[i]));
		}
		System.out.println(maxLen);
		return maxLen;
	} 

}