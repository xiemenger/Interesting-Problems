
/**
 * 1) the number of majority can not be larget than 2.
 *    Prof:  if there are k ( >= 33) majority number:
 *           k * (n / 3) >= 3 * (n / 3) 
 *                       >= n;  it cannot happen.
 * 2) let's assume we have 2 candiates. use two vairables to record 
 *    the candiate's count; cnt1 , cnt2.
 *    if cnt1 == 0, put cur num as cand1.
 *    if cnt2 == 0, put cur num as cand2.
 *    if num == cand1: cnt1++;
 *    if num == cand2: cnt2++;
 *    if me meet third differernt number, we can offset the two candiate by count 1.
 *       cnt1--;
 *       cnt2--;
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int cand1 = 0;
        int cnt1 = 0;
        int cand2 = 0;
        int cnt2 = 0;
        for (int num : nums){
            if (num == cand1){
                cnt1++;
            } else if (num == cand2){
                cnt2++;
            } else if (cnt1 == 0){
                cnt1++;
                cand1 = num;
            } else if (cnt2 == 0){
                cnt2++;
                cand2 = num;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums){
            if (num == cand1){
                cnt1++;
            } else if (num == cand2){
                cnt2++;
            }
        }
        if (cnt1 > nums.length / 3){
            res.add(cand1);
        }
        if (cnt2 > nums.length / 3){
            res.add(cand2);
        }
        return res;
    }
}