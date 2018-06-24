class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks){
            freq[c - 'A']++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        
        for (int num : freq){
            if (num > 0){
                 pq.offer(num);
            }
        }
        
        int len = 0;
        while (!pq.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int i = 0;
            while (i <= n){
                if (!pq.isEmpty()){
                    if (pq.peek() > 1){
                        tmp.add(pq.poll() - 1);
                    } else {
                        pq.poll();

                    }
                }
                i++;
                len++;
                // if reach the last block. no not need to fill the n len. break early.
                if (pq.isEmpty() && tmp.size() == 0){
                    break;
                }
            }
            for (int l : tmp){
                pq.offer(l);
            }
        }
        
        return len;
    }
}