class Solution {
    public int countCornerRectangles(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int[] row : grid){
            for (int i = 0; i < row.length; i++){
                if (row[i] == 1){
                    for (int j = i + 1; j < row.length; j++){
                        if (row[j] != 1){ continue; }
                        String val = ""+i+","+j;
                        int cur = map.getOrDefault(val, 0);
                        count += cur;
                        map.put(val, cur+1);
                    }
                }
            }
        }
        return count;
    }
}