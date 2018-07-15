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