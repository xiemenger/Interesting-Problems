class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        buidMap(seqs, map, indegree);
        
        Queue<Integer> q = new LinkedList<>();
        for (Integer k : indegree.keySet()){
            if (indegree.get(k) == 0){
                q.offer(k);
            }
        }
        
        
        int idx = 0;
        while (!q.isEmpty()){
            int size = q.size();
            if (size > 1){ return false; }
            
            int curNode = q.poll();
            if (idx >= org.length || curNode != org[idx++]){
                return false;
            }
            for (int next : map.get(curNode)){
                indegree.put(next, indegree.get(next)  - 1);
                if (indegree.get(next) == 0){
                    q.offer(next);
                }
            }
        }
        return idx == org.length && idx == map.size();
    }
    
    private void buidMap(List<List<Integer>> seqs, Map<Integer, Set<Integer>> map, Map<Integer, Integer> indegree){
        for (List<Integer> seq : seqs){
            if(seq.size() == 1){
                if (!map.containsKey(seq.get(0))){
                    map.put(seq.get(0), new HashSet<>());
                    indegree.put(seq.get(0), 0);
                } 
            } else {
                for (int i = 0; i < seq.size()  - 1; i++){
                    if (!map.containsKey(seq.get(i))){
                        map.put(seq.get(i), new HashSet<>());
                        indegree.put(seq.get(i), 0);
                    }  
                    
                    if (!map.containsKey(seq.get(i + 1))){
                        map.put(seq.get(i + 1), new HashSet<>());
                        indegree.put(seq.get(i + 1), 0);
                    } 
                    
                    if(map.get(seq.get(i)).add(seq.get(i+1))){
                        indegree.put(seq.get(i + 1), indegree.get(seq.get(i + 1)) + 1);
                    }
                }
            }

        }

    }
}