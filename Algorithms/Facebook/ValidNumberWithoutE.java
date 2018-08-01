public class FBValidNum {
	public static void main(String[] args) {
		System.out.println("0  :"+ validNum("0"));
		System.out.println(" 0.1  :"+ validNum(" 0.1"));
		System.out.println("abc :"+ validNum("abc"));
		System.out.println("1 a  :"+ validNum("1 a"));
		System.out.println("01.8  :"+ validNum("01.8"));
		System.out.println("1.8.2  :"+ validNum("1.8.2"));
		System.out.println("10 :"+ validNum("10"));
		System.out.println("1032  :"+ validNum("1032 "));
	}
	
	public static boolean validNum(String num) {
		num = num.trim();
		boolean dot = false;
		for (int i = 0; i < num.length(); i++){
			char cur = num.charAt(i);
			if (i > 0 && (cur == '+' || cur == '-')){
				return false;
			}
			if (cur != '.' && (cur < '0' || cur > '9')) {
				return false;
			}
			if (cur == '.') {
				if (dot) {
					return false;
				}
				dot = true;
			}
			if (i == 0 && cur == '0' && num.length() != 1) {
				return false;
			}
		}
		return true;
	}

}