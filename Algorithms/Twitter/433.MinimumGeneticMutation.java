class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)){
            return 0;
        }
        Set<String> bankSet = new HashSet<>();
        for (String word : bank){ bankSet.add(word); }
        
        int level = 0;
        Queue<String> nexts = new ArrayDeque<>();
        nexts.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        char[] dir = new char[]{'A', 'C', 'G', 'T'};
        
        while (!nexts.isEmpty()){
            int size = nexts.size();
            while (size-- > 0){
                String cur = nexts.poll();
                if (cur.equals(end)){
                    return level;
                }
                char[] curChars = cur.toCharArray();
                for (int i = 0; i < curChars.length; i++){
                    char old = curChars[i];
                    for (int k = 0; k < dir.length; k++){
                        curChars[i] = dir[k];
                        String next = new String(curChars);
                        if (bankSet.contains(next) && !visited.contains(next)){
                            nexts.offer(next);
                            visited.add(next);
                        }
                    }
                    curChars[i] = old;
                } 
            }
            level++;
        }
        return -1;
    }
}