class Solution {
    public int slidingPuzzle(int[][] board) {
        Set<String> seen = new HashSet<>();
        String target = "123450";
        Queue<String> nexts = new ArrayDeque<>();
        String start = toString(board);
        if (start.equals(target)){
            return 0;
        }
        nexts.offer(start);
        seen.add(start);
        int cnt = 0;
        int[] dir = new int[]{1, -1, board[0].length, -board[0].length};
        while (!nexts.isEmpty()){
            for (int sz = nexts.size(); sz > 0; sz--){
                String cur = nexts.poll();
                int zeroPos = cur.indexOf('0');
                for (int k = 0; k < dir.length; k++){
                    char[] c = cur.toCharArray();
                    int nextPos = zeroPos + dir[k];
                    if (nextPos < 0 || nextPos > 5 || 
                        (zeroPos == 2 && nextPos == 3) || (nextPos == 2 && zeroPos == 3)){
                        continue;
                    }
                    String nextStr = getNextString(c, zeroPos, nextPos);
                    if (nextStr.equals(target)){
                        return cnt+1;
                    }
                    if (seen.add(nextStr)){
                        nexts.offer(nextStr);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
    
    private String getNextString(char[] c, int zeroPos, int nextPos){
        char tmp = c[zeroPos];
        c[zeroPos] = c[nextPos];
        c[nextPos] = tmp;
        return new String(c);
    }
    
    private String toString(int[][] b){
        StringBuilder res = new StringBuilder();
        for (int[] row : b){
            for (int ele : row){
                res.append(ele);
            }
        }
        return res.toString();
    }
}