class Solution {
    // min heap   Time,O(klogk), Space:O(k)
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (int j = 0; j < matrix[0].length; j++){
            minHeap.offer(new Cell(0, j, matrix[0][j]));
        }
        
        for (int count = 0; count < k - 1; count++){
            Cell cur = minHeap.poll();
            if (cur.x < matrix.length - 1){
                minHeap.offer(new Cell(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
            }
        }
        return minHeap.poll().val;
    }
    
    class Cell{
        int val;
        int x;
        int y;
        public Cell(int _x, int _y, int _val){
            x = _x;
            y = _y;
            val = _val;
        }
    }
    
    // Binary Search. Time O(), Space O(1);
    public int kthSmallest2(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int lo = matrix[0][0];
        int hi = matrix[rows - 1][cols - 1] + 1;
    
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            int col = cols - 1;
            int counter = 0;
            for (int row = 0; row < rows; row++){
                while(col >= 0 && matrix[row][col] > mid){ col--; }
                counter += col + 1;
            }
            
            if (counter < k){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}