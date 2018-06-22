class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int bal = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                bal++;
            } else {
                bal--;
            }
            if (map.containsKey(bal)){
                max = Math.max(max, i - map.get(bal));
            } else {
                map.put(bal, i);
            }
        }
        return max;
    }
}