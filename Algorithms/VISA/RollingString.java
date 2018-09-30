public class RollingString {
	public static void main(String[] args) {
		String str = "abc";
		String[] op = new String[] {"0 0 L", "2 2 L", "0 2 R"};
		System.out.println(rollString(str, op));
	}
	
	private static String rollString(String str, String[] operations) {
		if (str.isEmpty() || operations == null || operations.length == 0) {
			return str;
		}
		
		int[] vals = new int[str.length()];
		for (String  op : operations) {
			String[] p = op.split(" ");
			int l = Integer.valueOf(p[0]);
			int r = Integer.valueOf(p[1]);
			int val = p[2].equals("L") ? -1 : 1;
			while (l <= r) {
				vals[l++] += val;
			}
		}
		
		char[] s = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			s[i] += vals[i];
			if (s[i] < 'a')
			    s[i] = (char)('z' - ('a' - s[i]) % ('z' - 'a'));
			else
				s[i] = (char)('a' + (s[i] - 'a') % ('z' - 'a'));
			
		}
		
		return new String(s);
	}
	
	private static String rollString2(String str, String[] operations) {
		if (str.isEmpty() || operations == null || operations.length == 0) {
			return str;
		}
		
		char[] s = str.toCharArray();
		for (String  op : operations) {
			String[] p = op.split(" ");
			int l = Integer.valueOf(p[0]);
			int r = Integer.valueOf(p[1]);
			int val = p[2].equals("L") ? -1 : 1;
			roll(s, l, r, val);
		}
		return new String(s);
	}
	
	private static void roll(char[] s, int l, int r, int val) {
		while (l <= r) {
			if (val < 0 && s[l] == 'a') {
				s[l] = 'z';
			} else if (val > 0 && s[l] == 'z') {
				s[l] = 'a';
			} else {
				s[l] = (char)(s[l] + val);
			}
			l++;
		}
	}

}