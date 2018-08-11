public class FBFindFrequenceOfTargetNumberInASortedArray {
	public static void main(String[] args) {
		//int[] nums = new int[] {1, 1, 1};
		//nt[] nums = new int[] {1};
		int[] nums = new int[] {1, 4, 4, 5, 6, 7, 7, 7, 8, 9};
		findFreqOfTarget(nums, 7);
	}
	
	private static void findFreqOfTarget(int[] nums,int target) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int leftIdx = searchLeft(nums, target);
		int rightIdx= searchRight(nums, target);
		if(nums[leftIdx] != target) {
			System.out.println("no such target in the input array : left:"+leftIdx);
		} else {
			System.out.println("len is "+(rightIdx - leftIdx + 1));
		}
	}
	
	private static int searchLeft(int[] nums, int target) {
		int lo = 0;
		int hi = nums.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] < target) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}
	
	private static int searchRight(int[] nums, int target) {
		int lo = 0;
		int hi = nums.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo + 1) / 2;
			if (nums[mid] <= target) {
				lo = mid;
			} else {
				hi = mid - 1;
			}
		}
		return lo;
	}
}