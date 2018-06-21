class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++){
            String[] e = equations[i];
            if (!map.containsKey(e[0])){
                map.put(e[0], new HashMap<>());
            }
            map.get(e[0]).put(e[1], values[i]);
            
            if (!map.containsKey(e[1])){
                map.put(e[1], new HashMap<>());
            }
            map.get(e[1]).put(e[0], 1/values[i]);
        }
        
        int m = queries.length;
        double[] res = new double[m];
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < m; i++){
            if(queries[i][0].equals(queries[i][1]) && map.containsKey(queries[i][0])){
                res[i] = 1.0;
                continue;
            }
            res[i] = dfs(map, visited, queries[i][0], queries[i][1], 1.0);
            if(res[i] == 0.0){
                res[i] = -1.0;
            }
            visited.clear();
        }
        return res;
    }
    
    public double dfs(Map<String, Map<String, Double>> map, Set<String> visited, String start, String end, double val){
        if (visited.contains(start) || !map.containsKey(start)){
            return 0.0;
        }
        
        double res = 0.0;
        visited.add(start);
        Map<String, Double> edges = map.get(start);
        for (String key: edges.keySet()){
            if (key.equals(end)){
                return val*edges.get(key);
            }
            res = dfs(map, visited, key, end, val*edges.get(key));
            if (res != 0.0){ break; }
        }
        return res;
    }
}