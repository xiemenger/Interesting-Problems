class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new LinkedList<>();
        int n = arr.length;
        int pos = Arrays.binarySearch(arr, 0, n, x);
        System.out.println("pos:"+pos);
        if (pos < 0 ){
            pos = -pos - 1;
        }
        int l = pos - 1;
        int r = pos;
        
        while (l >= 0 && r < n && k > 0){
            if (x - arr[l] <= arr[r] - x){
                res.add(0, arr[l--]);
            } else {
                res.add(arr[r++]);
            }
            k--;
        }
        
        while (k > 0 && l >= 0){
            res.add(0, arr[l--]);
            k--;
        }
        
        while (k > 0 && r < n){
            res.add(arr[r++]);
            k--;
        }
        return res;
    }
    
    
}