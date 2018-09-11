/**
 * 2. find 4 missing numbers in 1-100, 
 * given an array with size of 96, 
 * guarantee every number in it is unique.
 */

 class Solution{
    public static List<Integer> findMissingnumber(int[] nums) {
		boolean[] exist = new boolean[Integer.MAX_VALUE];
		List<Integer> res = new ArrayList<>();
		for (int num : nums) {
			exist[num - 1]  = true;
		}
		System.out.println("The missing number are: ");
		for (int i = 0; i < exist.length; i++) {
			if (!exist[i]) {
				res.add((i+1));
				System.out.print((i+1)+",");
			}
		}
		return res;
	}
 }