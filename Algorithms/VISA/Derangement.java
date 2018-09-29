public class Derangement {
	/**
	 * 4 -> 24
	 * 5 -> 120
	 * 6 -> 720 
	 * 7 -> 5040
	 */
	public static void main(String[] args) {
		System.out.println(derangementCount(7));
	}
	
	private static Map<Integer, Integer> cacheData = new HashMap<>();
	public static int derangementCount(int n) {
		if (n == 0 || n == 1) {return 0; }
		if (n == 2) {return 2; }
		if (n == 3) {return 6; }
		if (cacheData.containsKey(n)) {
			return cacheData.get(n);
		}
		int res = (n - 1) * (derangementCount(n - 1) + derangementCount (n - 2)); 
		//System.out.println(res);
		cacheData.put(n, res);
		return res;
	}

}