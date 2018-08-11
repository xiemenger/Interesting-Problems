class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0){return false; }
        Map<Integer, Set<Integer>> steps = new HashMap<>();
        
        for (int stone : stones){
            steps.put(stone, new HashSet<>());
        }
        steps.get(0).add(1);
        int lastStep = stones[stones.length - 1];
        for (int stone : stones){
            for (int step : steps.get(stone)){
                int reach = step + stone;
                if (reach == lastStep){return true; }
                if (steps.containsKey(reach)){
                    Set<Integer> jumps = steps.get(reach);
                    jumps.add(step);
                    jumps.add(step + 1);
                    if (step - 1 > 0){
                        jumps.add(step - 1);
                    }
                }
            }
        }
        return false;
    }
}