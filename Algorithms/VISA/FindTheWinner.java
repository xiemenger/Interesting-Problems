public class FindTheWinner {

	public static void main(String[] args) {
		System.out.println(getWinner("even", 
									new int[] {1, 2, 3},
									new int[] {2, 1, 3}));
		System.out.println(getWinner("odd", 
				new int[] {3, 5, 10},
				new int[] {3, 0, 7}));
	}
	
	public static String getWinner(String flip, int[] andrea, int[] maria) {
		int idx = flip.equals("even") ? 0 : 1;
		int aScore = 0;
		int mScore = 0;
		for (; idx < andrea.length; idx += 2) {
			int val = andrea[idx] - maria[idx];
			aScore += val;
			mScore += -val;
		}
		System.out.println(aScore +"  "+ mScore);
		return aScore > mScore ? "andrea" : aScore ==  mScore ? "tie" : "maria";
	}

}