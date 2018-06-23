class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0){
            return 0;
        }
        
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++){
            List<Integer> list = wall.get(i);
            int len = 0;
            for (int j = 0; j < list.size()-1; j++){
                len += list.get(j);
                map.put(len, map.getOrDefault(len, 0) + 1);
                count = Math.max(count, map.get(len));
            }
        }
        return wall.size() - count;
    }
}