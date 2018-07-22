class Solution {
    public int hIndex(int[] citations) {
        int res = 0;
        int len = citations.length;
        int l = 0;
        int r = len - 1;
        while (l < r){
            int mid = l + (r - l) / 2;
            if (citations[mid] < len - mid){
                l = mid + 1;
            } else {
                r = mid;
            } 
        }
        if (l < len && citations[l] >= len - l){
            return len - l;
        }
        return 0;
    }
}