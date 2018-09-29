/*
Q1: 原题见图。其实就一个包含0和1的array， 需要把1放到一边 0放到一边，只能邻接element交换 求最小steps。
e.g. 011001 -> 4 (011001 -> 010101 -> 001101 -> 001011 -> 000111)
当时没做出来，后来想想，因为不确定0和1各放在哪边解最优，
就先0放左，two pointer，左边指向第一个非0的，右边指向第一个非1的，然后算距离，swap；直到指针相遇；
再把1放左，重复算法；
最后取2个的最小值
 *
 */
public class MinimumStepToSort {
	public static void main(String[] args) {
		int[] bin = new int[] {1, 1, 1, 0, 0, 1};
		System.out.println(calculateMini(bin));
	}
	
	public static int calculateMini(int[] bin) {
		if (bin == null || bin.length == 0) {return 0; }
		int l = 0;
		int r = bin.length - 1;
		int steps = 0;
		while (l < r) {
			while (l < r && bin[l] == 0) {l++; }
			while (l < r && bin[r] == 0) {r--; }
			if (l < r) {
				steps += r - l;
			}
			l++; r--;
		}
		return steps;
	}

}