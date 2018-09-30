public class BinaryJump {
	public static void main(String[] args) {
		//int[] nums = new int[] {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0};
		int[] nums = new int[] {1, 0, 1, 0, 1};
		System.out.println(binaryJumps(nums));
	}
	
	public static int binaryJumps(int[] nums) {
		if (nums == null || nums.length == 0) {return 0; }
		int val = nums[nums.length - 1];
		int lastIdx = -1;
		int maxJump = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				maxJump = Math.max(maxJump, i - lastIdx);
				lastIdx = i;
			}
		}
		return maxJump;
	}
}