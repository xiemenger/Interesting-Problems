class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets){
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        
        Stack<String> stack = new Stack<>();
        List<String> res = new ArrayList<>();
        stack.push("JFK");
        while (!stack.isEmpty()){
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()){
                stack.push(map.get(stack.peek()).poll());
            }
            
            res.add(0, stack.pop());
        }
        return res;
    
    }
}