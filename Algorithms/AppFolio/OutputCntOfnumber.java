/**
 * 就一题，不难，给你一个input array，让你输出三个array，第一个array是所有duplicates，第二个是所有single，第三个是所有number
example：
input = [1, 4, 2, 8, 2, 9, 1, 8, 3, 3];
output：(要print出来).
>> Values Found >1 Times: [2, 8, 1, 3]
>> Values Found 1 Time:   [4, 9]
>> De-Duplicated Array:   [1, 4, 2, 8, 9, 3]


用了最直接的hashmap。做出来了
follow up： 能不能one pass？ 我问能不能多个data structure，他说可以，可以用多个hashmap 或者array
我就用三个map做了，他很满意，说了一些下轮面试的情况blablabla
总体感觉还行？
就这样了，期待下一轮
 * 
 */

 class Solution{
    private static void printNumberCnt(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		Map<Integer, Integer> cnts = new HashMap<>();
		for (int num : nums) {
			cnts.put(num, cnts.getOrDefault(num, 0) + 1);
		}
		
		System.out.println("The nums appears more than once: ");
		for (int key : cnts.keySet()) {
			if (cnts.get(key) > 1) {
				System.out.print(key+ ",");
			}
		}
		System.out.println("");
		System.out.println("The nums appears only once: ");
		for (int key : cnts.keySet()) {
			if (cnts.get(key) == 1) {
				System.out.print(key+ ",");
			}
		}
		System.out.println("");
		System.out.println("All number: ");
		for (int key : cnts.keySet()) {
			System.out.print(key+ ",");
		}
	}


    private static void onePass(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		Set<Integer> onces = new HashSet<>();
		Set<Integer> moreThanOnce = new HashSet<>();
		Set<Integer> alls = new HashSet<>();
		for (int num : nums) {
			if (!onces.add(num)){
				onces.remove(num);
				moreThanOnce.add(num);
			}
			alls.add(num);
		}
		
		System.out.println("The nums appears more than once: ");
		for (int key : moreThanOnce) {
			System.out.print(key+ ",");
		}
		
		System.out.println("");
		System.out.println("The nums appears only once: ");
		for (int key : onces) {
			System.out.print(key+ ",");
		}
		
		System.out.println("");
		System.out.println("All number: ");
		for (int key : alls) {
			System.out.print(key+ ",");
		}
	}

 }

