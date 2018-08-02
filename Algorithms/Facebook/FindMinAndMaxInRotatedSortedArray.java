	class solution {/**
	 * 做binary search的时候, 比如你要最大数
	 * 那么你就要先看 nums<m>  < 的情况. 因为>= 的情况, 我们移动的指针是要 = m的. 
	 * 经验总结, 要比start值, m 要 r + l + 1 / 2;
	 * nums[m] >= nums[lo]  lo = m;  可能是lo, 这种情况下我们的m 一定要(r + l + 1) / 2;
	 * nums[m] < nums[lo]  hi = m - 1;
	 * 
	 * 相反:
	 * 分析找最小的情况.
	 * 
	 * @param nums
	 * @return
	 */
	private int findMax(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int lo = 0;
		int hi = nums.length - 1;
		while (lo < hi) {
			int m = lo + (hi - lo + 1) / 2;
			if (nums[m] < nums[lo]) {
				hi = m - 1;
			} else {
				lo = m;
			}
		}
		System.out.println("index:"+lo+"   max value:"+nums[lo]);
		return lo;
	}
	
	private  int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int lo = 0;
		int hi = nums.length - 1;
		while (lo < hi) {
			int m = lo + (hi - lo) / 2;
			if (nums[m] > nums[hi]) {
				lo = m + 1;
			} else {
				hi = m;
			}
		}
		System.out.println("index:"+lo+"   min value:"+nums[lo]);
		return lo;
    }
}
