/**
 * 给一个数, 判定他的二进制表示是否是一个palindrome, 
 * 比如3的二进制是11, 就是palindrome
 */

 class Solution{
     // transfer to a string
    private static boolean isPalidrome(int num) {
		StringBuilder numstr = new StringBuilder();
		int i = 0;
		while (i< 32) {
			numstr.append(num & 1);
			num >>>= 1; // unsigned shift.
			i++;
		}
		return check(numstr.toString());
	}
    
    // check the string.
	private static boolean check(String num) {
		int l = 0;
		int r = num.length() - 1;
		while (l < r) {
			if (num.charAt(l++) != num.charAt(r--)) {
				return false;
			}
		}
		return true;
	}
	
 }