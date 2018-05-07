class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int idx1= 0; 
        int idx2 = numbers.length - 1;
        while (idx1 < idx2){
            if (numbers[idx1] + numbers[idx2] == target){
                res[0] = idx1 + 1;
                res[1] = idx2 + 1;
                break;
            } else if (numbers[idx1] + numbers[idx2] < target){
                idx1++;
            } else {
                idx2--;
            }
        }
        return res;
    }
}