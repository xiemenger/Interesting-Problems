/**
 * {1,3,5,10, 4,4,2} , 左边odds, 右边even 找第一个even, . 留学申请论坛-一亩三分地
二分查找, 

follow up: 不可以用 length, 只能get(index), 我: 2,4,8, 直到unavailable.  ?????? 
 */

 class Solution{
    public int FindFirstEvenNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		int l = 0;
		int r = nums.length - 1;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (nums[m] % 2 == 0) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		System.out.println("index: "+r);
		System.out.println("number: "+nums[r]);
		return nums[r] % 2 == 0 ? r : -1;
	}
 }