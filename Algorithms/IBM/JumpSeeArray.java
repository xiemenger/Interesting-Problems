/**
 * 1. array[1,2,3,4,5] 从0开始，i =i + array[i] 
 *     走到结束为止输出最后一个看到的值.
 * 2. 2. array1[1,a,3,4,5,...a,.......],
 *       array2[1,2,a,4,5,..a.....]， 做第一题的过程，
 *        如果看到 a，拿着当前的index换到另一个array里面继续走. 
 *       输出最后看到的值和是哪个array里面的，0就是第一个array，
 *       1就是第二个 eg. [value,0]
 */

public class SwitchSee {
	public static void main(String[] args) {
		int[] arr = new int[] {2,1,5,4,3,2,1,4,2,3,1,4,1};
		System.out.println(getLastSeenSingleArray(arr));
		//char[] arr1 = new char[] {'1','a','5','4','3','2','1','4','2','3','1','4','1'};
		char[] arr1 = new char[] {'a','a','5'};
		char[] arr2 = new char[] {'2','2','5','a','3','2','1'};
		lastSeen(arr1, arr2);
	}
	
	private static int getLastSeenSingleArray(int[] nums) {
		int idx = 0;
		while (idx < nums.length && idx + nums[idx] < nums.length) {
			idx += nums[idx];
		}
		return nums[idx];
	}
	
	private static int[] lastSeen(char[] arr1, char[] arr2) {
		int step = 0;
		int lastSeen = arr1[0];
		char[] toSeen = arr1;
		while (step < toSeen.length) {
			if (toSeen[step] == 'a') {
				toSeen = toSeen == arr1 ? arr2 : arr1;
				if (step >= toSeen.length) {
					toSeen = toSeen == arr1 ? arr2 : arr1;
					break;
				}
			} else {
				lastSeen = toSeen[step] - '0';
				step += toSeen[step] - '0';
			}
		}
		int[] res = new int[2];
		res[0] = lastSeen;
		res[1] = toSeen == arr1 ? 0 : 1;
		System.out.println("lastSeen Num:"+res[0]+"   arr is:"+res[1]);
		return res;
	}
}