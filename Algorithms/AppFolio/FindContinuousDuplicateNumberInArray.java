/**
 * Time: O(n)
 * Space: O(n)
 */

class solution{
    public int[] findDuplicates(int[] nums){
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

        int[] res = new int[duplicates.size()];
        int i = 0;
        for (int num : duplicates){
            res[i++] = num;
        }
        return num;
    }

}