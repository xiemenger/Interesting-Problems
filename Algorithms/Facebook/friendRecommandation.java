class solution{
    public List<Integer> getRecommendation(Person p, int k){
        List<Integer> res = new ArrayList<>();
        if (p == null || k <=0 ){
            return res;
        }
        Map<Integer, Integer> ffriends = new HashMap<>();
        int maxCnt = 0;
        for (int friend : p.friends){
            for (int ffriend : getFriend(friend)){
                if (p.friends.containsKey(ffriend) || ffriend == p.id){
                    continue;
                }
                ffriends.put(ffriend, ffriends.getOrDefault(ffriend, 0) + 1);
                maxCnt = Math.max(maxCnt, ffriends.get(ffriend));
            }
        }
        List<Integer>[] cnts = new List[maxCnt + 1];
        for (int id : ffriends.keySet()){
            int cnt = ffriends.get(id);
            if (cnts[cnt] == null){
                cnts[cnt] = new ArrayList<>();
            }
            cnts[cnt].add(id);
        }
        
        for (int i = maxCnt; i >= 0; i--){
            if (cnts[i] != null){
                for (int id : cnts[i]){
                    res.add(id);
                    k--;
                    if (k == 0){
                        return res;
                    }
                }
            }
        }
        return res;
    }

    public Set<Integer> getFriend(int id){
        return new HashSet<Integer>();
    }
}


class Person{
    int id;
    HashSet<Integer> friends = new HashSet<>();
}