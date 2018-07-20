class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int idx = 0;
        int n = intervals.size();
        
        // add all intervals into the res, which  has no intersection with new interval.
        while (idx < n && intervals.get(idx).end < newInterval.start){
            res.add(intervals.get(idx++));
        }
        
        // add all intervals int the res, which has intersection with new interval.
        while (idx < n && intervals.get(idx).start <= newInterval.end){
            newInterval.start = Math.min(newInterval.start, intervals.get(idx).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(idx).end);
            idx++;
        }
        res.add(newInterval);
        
        // all all intervals that left in intervals list.
        while (idx < n){
            res.add(intervals.get(idx++));
        }
        return res;
    }
}