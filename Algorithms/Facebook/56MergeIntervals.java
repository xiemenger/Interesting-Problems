class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0){
            return res;
        }
        
        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++){
            Interval last = res.get(res.size() - 1);
            Interval cur = intervals.get(i);
            if (cur.start <= last.end){
                last.end = Math.max(last.end, cur.end);
            } else {
                res.add(cur);
            }
        }
        return res;
    }
}