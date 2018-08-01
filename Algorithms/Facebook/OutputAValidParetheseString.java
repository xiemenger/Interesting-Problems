public class FBOutputAValidParentheseStringjava {
	public static void main(String[] args) {
		//String s = "((*(a))";
		//String s = "((a)";
		//String s = "((a)))))";
		String s = "((a)))())";
		System.out.println(s);
		String news = removeInvalidParentheses(s, 0, '(', ')');
			System.out.println(news);
			news = new StringBuilder(news).reverse().toString();
			news = removeInvalidParentheses(news, 0, ')', '(');
			System.out.println(news);
			news = new StringBuilder(news).reverse().toString();
			System.out.println(news);
	}
	
	private static String removeInvalidParentheses(String s, int pos, char leftParenthese, char rightParenthese) {
		int leftCnt = 0;
		int rightCnt = 0;
		for (int i = pos; i < s.length();i++) {
			if (s.charAt(i) == leftParenthese) { leftCnt++; }
			else if (s.charAt(i) == rightParenthese){ rightCnt++; }
			
			if (rightCnt > leftCnt) {
				return removeInvalidParentheses(s.substring(0, i) + s.substring(i + 1), i, leftParenthese, rightParenthese);
			} 
		}
		return s;
	}

}