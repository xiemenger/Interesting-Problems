class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> map = new HashMap<>();
        return recursiveSearch(input, map);
    }
    
    public List<Integer> recursiveSearch(String s, Map<String, List<Integer>> map){
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n - 1; i++){
            char cur = s.charAt(i);
            if (cur != '+' && cur != '-' && cur != '*'){ continue; }
            String s1 = s.substring(0, i);
            String s2 = s.substring(i+1);
            List<Integer> r1 = map.getOrDefault(s1, recursiveSearch(s1, map));
            List<Integer> r2 = map.getOrDefault(s2, recursiveSearch(s2, map));
            int val = 0;
            for (int num1 : r1){
                for (int num2: r2){
                    switch(cur){
                        case '+':
                            val = num1 + num2;
                            break;
                        case '-':
                            val = num1 - num2;
                            break;
                        case '*':
                            val = num1 * num2;
                            break;
                    }
                    res.add(val);
                }
            }
        }
        // s is a number
        if (res.size() == 0){
                res.add(Integer.valueOf(s));
        }
        map.put(s, res);
        
        return res;
    }
}