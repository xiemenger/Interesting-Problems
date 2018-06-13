class SummaryRanges {

    /** Initialize your data structure here. */
    TreeMap<Integer, Interval> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if (map.containsKey(val)){
            return;
        }
        Integer l = map.lowerKey(val);
        Integer h = map.higherKey(val);
        if (l != null && h != null && (map.get(l).end+1) == val && h-1 == val){
            map.get(l).end = map.get(h).end;
            map.remove(h);
        } else if (l != null && map.get(l).end+1 >= val){
            map.get(l).end = Math.max(map.get(l).end, val);
        } else if (h != null && h == val + 1){
                map.put(val, new Interval(val, map.get(h).end));
                map.remove(h);
        } else {
            map.put(val, new Interval(val, val));
        }
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}