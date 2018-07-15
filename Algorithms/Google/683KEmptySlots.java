/**
 * Two method:
 * Method 1:
 * idea: use pos as index, if we go to pos i, we check
 * the closest position l to the i which is blooming,
 * if l == i - k - 1; return
 * or we check the closest position r to the i which is
 * blooming, if r = i + k + 1. return.
 * 
 * here we use TreeSet to store the blooming positions.
 * use .lower, .higher to find the closest blooming 
 * position by using log(n).
 * Time: O(nlog(n)), Space: O(nlog(n))
 * 
 * 
 * Another solution:
 * Idea: position window size k + 2 (leftmost, rightmost)
 * As we know, if we want the left edge flower and
 * right edge flower blooming, and the flowers between
 * are not blooming, that means the left edge flower and
 * right edge flower's bloowing date are the smallest dates
 * in the window size k + 2.
 * In another ways, the dates of flowers' between left edge flower 
 * and the right edge floswer must larger than leftmost and
 * rightmost flowers' date. 
 * 
 */

class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length;
        int l = 0;
        int r = l + k + 1;
        int[] days = new int[n];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            days[flowers[i] - 1] = i + 1;
        }
        
        for (int i = 0; r < n; i++){
            if (days[i] < days[l] || days[i] <= days[r]){
                if (i == r){
                    res = Math.min(res, Math.max(days[l], days[r]));
                }
                l = i;
                r = i + k + 1;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    public int kEmptySlots2(int[] flowers, int k) {
        int n = flowers.length;
        TreeSet<Integer> blooming = new TreeSet<>();
        
        for (int day = 1; day <= n; day++){
            int pos = flowers[day - 1];
            blooming.add(pos);
            Integer lower = blooming.lower(pos);
            Integer higher = blooming.higher(pos);
            if ((lower != null && pos - lower == k + 1) ||
               (higher != null && higher - pos == k + 1)){
                return day;
            }
        }
        return -1;
    }
}