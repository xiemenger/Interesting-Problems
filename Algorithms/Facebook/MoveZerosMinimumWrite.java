class solution{
 public void minimumWrite(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		int cnt = 0;
		while (l < r) {
			while (l <= r && nums[l] != 0) {
				l++;
			}
			while (l <= r && nums[r] == 0) {
				r--;
			}
			if (l < r) {
				swap(nums, l++, r--);
				cnt++;
			}
		}
		for (int num : nums) {
			System.out.print(num+",");
		}
		System.out.println("  Swap number:"+cnt);
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
    }
}