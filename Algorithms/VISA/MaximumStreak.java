public class MaximumStreak {
	public static void main(String[] args) {
		char[][] data = new char[][] {{'Y','Y','Y'}, 
									  {'Y','Y','Y'},
									  {'Y','N','N'},
									  {'Y','Y','N'},
									  {'Y','Y','N'},
									};
		System.out.println(maximumStreak(3, data));
	}
	
	public static int maximumStreak(int m, char[][] data) {
		int cnt = 0;
		int max = 0;
		for (char[] row : data) {
			int i = 0;
			for (;i < row.length; i++) {
				if (row[i] == 'N') {
					break;
				}
			}
			if (i == row.length) {
				cnt++;
				max = Math.max(max, cnt);
			} else {
				cnt = 0;
			}
		}
		return max;	
	}
}
