

    
/**
 * an array, find number of combinations which meet following request, min  + max <= target;. 
Eg. Given [2,4,5,7], target is 8. more info on 1point3acres
You should return 5。
[2], [2,4] ,[2,4,5],[2,5],[4], 
[5] 不行, 因为min=5, max = 5  5+5 > 8
 * @author jolie
 *
 */

    public class FindMinMaxSumLessThanTarget {
        
        private  int Search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int cnt = 0;
            Arrays.sort(nums);
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                if (nums[l] + nums[r] > target) {
                    r--;
                } else {  // <= target.
                    int dist = r - l;
                    int tmp = 1;
                    for (int i = 0; i < dist; i++) {
                        tmp *= 2;
                    }
                    cnt += tmp;
                    l++;
                }
            }
            System.out.println("cnt:"+cnt);
            return cnt;   
        }
}
