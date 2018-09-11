/**
 * 给一个sorted array和一个数值v, 返回subarray的中位数, 
 * subarray就是array里面数值大于v的数组成的. 
 * 算法就是binary search找到subarray的开始index, 然后计算中位数.
 */

 class Solution{
    public int findMind(int[] nums, int val) {
		int idx = findPosition(nums, val);
		return idx + (nums.length - 1 - idx) / 2;
	}
	
	private int findPosition(int[] nums, int val) {
		int l = 0;
		int r = nums.length;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (nums[m] <= val) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		System.out.println("the position is : "+l);
		return l;
	}
 }