class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int student = 0; student < n; student++){
            if (!visited[student]){
                visited[student] = true;
                count++;
                search(student, M, visited);
            }
        }
        return count;
    }
    
    private void search(int student, int[][] M, boolean[] visited){
        for (int friend = 0; friend < M.length; friend++){
            if (M[student][friend] == 1 && !visited[friend]){
                visited[friend] = true;
                search(friend, M, visited);
            }
        }
    }
}