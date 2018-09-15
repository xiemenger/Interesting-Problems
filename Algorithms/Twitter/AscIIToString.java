class Solution{
    public static void main(String[] args) {
		String s = "23511011501782351112179911801562340161171141148";
		System.out.println(toString(s));
	}
	
	private static String toString(String num) {
		num = new StringBuilder(num).reverse().toString();
		int i = 0;
		StringBuilder res = new StringBuilder();
		while (i < num.length() - 1) {
			int code = Integer.valueOf(""+num.charAt(i) + num.charAt(i + 1));
			i += 2;
			if(code != 32 && !(code >= 'A' && code <= 'Z') && !(code >= 'a' && code <= 'z')) {
				code = Integer.valueOf("" + code + num.charAt(i));
				i++;
			}
			res.append((char)code);
		}
		return res.toString();
	}

}