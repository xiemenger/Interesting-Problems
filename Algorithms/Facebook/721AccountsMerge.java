class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> name = new HashMap<>();
        for (List<String> acount : accounts){
            String head = "";
            String firstEmail = acount.get(1);
            for (String email : acount){
                if (head.equals("")){
                    head = email;
                    continue;
                }
                if (!graph.containsKey(firstEmail)){
                    graph.put(firstEmail, new HashSet<>());
                }
                graph.get(firstEmail).add(email);
                if (!graph.containsKey(email)){
                    graph.put(email, new HashSet<>());
                }
                graph.get(email).add(firstEmail);
                name.put(email, head);
            }  
        }
        
        List<List<String>> res = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        for (String email : graph.keySet()){
            if (!seen.contains(email)){
                res.add(bfs(graph, email, seen, name));
            }
        }
        return res;
    }
    
    private List<String> bfs(Map<String, Set<String>> graph, String email, Set<String> seen, Map<String, String> name){
        List<String> res = new LinkedList<>();
        Queue<String> q = new LinkedList<>();
        q.offer(email);
        while (!q.isEmpty()){
            String curemail = q.poll();
            if (!seen.contains(curemail)){
                seen.add(curemail);
                res.add(curemail);
                for (String next : graph.get(curemail)){
                    q.offer(next);
                }
            }
        }
        Collections.sort(res);
        res.add(0, name.get(email));
        return res;
    }
}