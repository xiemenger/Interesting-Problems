/**
 * 给一个全是数字的string 假设是循坏的，
 * 求满足连续出现数字的和。比如“1122”-》3 1和2 是连续出现，
 * “1234”-》0 没有连续的，
 * “31212123”=》 3  只有3 连续出现。
 * 
 * Time: O(n)
 * Space: O(n)
 */

class solution{
    public int findDuplicates(int[] nums){
        if (nums == null || nums.length == 0){
            return new int[0];
        }

        Set<Integer> duplicates = new HashSet();
        for (int i = 0; i < nums.length; i++){
            if (i == nums.length - 1){
                if (nums[i] == nums[0]){
                    duplicates.add(nums[i]);
                }
                break;
            }
            if (nums[i] == nums[i + 1]){
                duplicates.add(nums[i]);
            } 
        }

        int sum = 0;
        for (int num : duplicates){
            sum += num;
        }
        return sum;
    }

}