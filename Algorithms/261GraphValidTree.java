class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1){
            return false;
        }
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        for (int[] edge : edges){
            int x = findDest(nums, edge[0]);
            int y = findDest(nums, edge[1]);
            if (x == y){
                return false;
            }
            
            nums[x] = y;
        }
        
        return true;
    }
    
    public int findDest(int[] nums, int i){
        if (nums[i] == -1){ return i; }
        return findDest(nums, nums[i]);
    }
}