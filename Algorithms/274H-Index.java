class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        int res = 0;
        for (int i = 0; i < n; i++){
            if(citations[i] > n){
                count[n] += 1;
            } else {
                count[citations[i]] += 1;
            }
        }
        
        int sum = 0;
        for (int i = n; i >= 0; i--){
            sum += count[i];
            if (sum >= i){
                res = i;
                break;
            }
        }
        return res;
    }
}