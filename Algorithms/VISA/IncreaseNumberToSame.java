/**
 * Array有n个数，
 * 每步操作是 将 (n - 1) 个数增加 1. 
 * 问最少几步可以让所有数字相等
 * 
 * 解法的思想是, 如果增加(n - 1)数 by 1>
 * 其实就是对一个数 进行减 1. 
 * 所以每步操作就是对一个数进行减1.
 * 
 * 先找出minimum number in the array.
 * 然后每个数减少到minimum number就可以.
 * 
 * for all i that 
 *  steps += a[i] - min;
    
    => steps = a[0] + a[1] + .. + a[n - 1] - n * min
             = sum - n * min
 */

public class IncreaseNumToSame {
	public static void main(String[] args) {
		int[] nums = new int[] {0, 1, 1, 1};
		System.out.println(countMinimumSteps(nums));
	}
	
	public static int countMinimumSteps(int[] nums) {
		if (nums == null || nums.length == 0) {return 0; }
		int steps = 0;
		long sum = 0;
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			sum += num;
			min = Math.min(min, num);
		}
		return (int)(sum - ( min * nums.length ));
	}
}
