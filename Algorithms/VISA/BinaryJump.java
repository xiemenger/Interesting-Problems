public class BinaryJump {
	public static void main(String[] args) {
		int[] nums = new int[] {1, 0, 1, 0, 1};
		System.out.println(binaryJumps(nums));
	}
	
	public static int binaryJumps(int[] nums) {
		if (nums == null || nums.length == 0) {return 0; }
		int lastOneIdx = -1;
		int maxJump = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				maxJump = Math.max(maxJump, i - lastOneIdx);
				lastOneIdx = i;
			}
		}
		return maxJump;
	}
	
}