class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int expectNextNum = lower;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < expectNextNum){
                continue;
            }
            if (nums[i] == expectNextNum){
                expectNextNum++;
                if (expectNextNum == Integer.MIN_VALUE){
                    return res;
                }
                continue;
            }
            res.add(getRange(expectNextNum, nums[i] - 1));
            expectNextNum = nums[i] + 1;
            if (expectNextNum == Integer.MIN_VALUE){
                return res;
            }
        }
        //if last number is Integer_MAX, +1 will be min;
        if (expectNextNum <= upper){
            res.add(getRange(expectNextNum, upper));
        }
        return res;
    }
    
    public String getRange(int n1, int n2){
        return n1 == n2 ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }
}