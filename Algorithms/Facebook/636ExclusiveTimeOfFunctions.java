class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> idStack = new Stack<>();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        idStack.push(Integer.valueOf(s[0]));
        int prev = Integer.valueOf(s[2]);
        int i = 1;
        
        while (i < logs.size()){
            s = logs.get(i).split(":");
            int time = Integer.valueOf(s[2]);
            if (s[1].equals("start")){
                if (!idStack.isEmpty()){
                    res[idStack.peek()] += time - prev;
                }
                idStack.push(Integer.valueOf(s[0]));
                
            } else {
                time += 1;
                res[idStack.pop()] += time - prev;
            }
            prev = time;
            i++;
        }
        return res;
    }
}