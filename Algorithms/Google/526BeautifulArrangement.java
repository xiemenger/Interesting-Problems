class Solution {
    public int countArrangement(int N) {
        int[] nums = new int[N];
        for (int i = 0; i < N; i++){
            nums[i] = i+1;
        }
        int[] count = new int[1];
        boolean[] visited = new boolean[N+1];
        return permutate(nums, 0);
        //return backtrack(N, 1, visited);
    }
    
    private int backtrack(int N, int pos, boolean[] visited){
        if (pos > N){
            return 1;
        }
        int res = 0;
        for (int i = 1; i <= N; i++){
            if (!visited[i] && (i % pos == 0 || pos % i == 0)){
                visited[i] = true;
                res += backtrack(N, pos+1, visited);
                visited[i] = false;
            }
        }
        return res;
    }
    
    private int permutate(int[] nums, int idx){
        if (idx == nums.length){
            return 1;
        }
        int res = 0;
        for (int i = idx; i < nums.length; i++){
            swap(nums, idx, i);
            if (nums[idx] % (idx+1) == 0 || (idx+1) % nums[idx] == 0){
                res += permutate(nums, idx+1);
            }
            swap(nums, idx, i);
        }
        return res;
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}