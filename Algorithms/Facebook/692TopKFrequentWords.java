class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqs = new HashMap<>();
        for (String word : words){
            freqs.put(word, freqs.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> minQ = new PriorityQueue<>((a,b) ->
         a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
        
        for (Map.Entry<String, Integer> entry : freqs.entrySet()){
            minQ.offer(entry);
            if (minQ.size() > k){
                minQ.poll();
            }
        }
        List<String> res = new LinkedList<>();
        while (!minQ.isEmpty()){
            res.add(0, minQ.poll().getKey());
        }
        return res;
    }
}