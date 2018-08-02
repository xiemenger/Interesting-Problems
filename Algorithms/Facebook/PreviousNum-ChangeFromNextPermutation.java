class solution{
    private void previousNum(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int n = nums.length;
		int fIidx = n - 2;
		while (fIidx >= 0 && nums[fIidx ] <= nums[fIidx + 1]) {
			fIidx--;
		}
		if (fIidx >= 0) {
			int flidx = n - 2;
			while (flidx >= 0 && nums[flidx] >= nums[flidx + 1]) {
				flidx--;
			}
			swap(nums, fIidx, flidx);
		}
		reverse(nums, fIidx + 1, n - 1);
		printNum(nums);
    } 
}