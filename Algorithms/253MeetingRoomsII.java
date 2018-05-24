/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        int[] sp = new int[n];
        int[] ep = new int[n];
        
        for(int i = 0; i < n; i++){
            sp[i] = intervals[i].start;
            ep[i] = intervals[i].end;
        }
        
        int s = 0; 
        int e = 0;
        int count = 0;
        int rooms = 0;
        Arrays.sort(sp);
        Arrays.sort(ep);
        while (s < n && e < n){
            while (s < n && sp[s] < ep[e]){
                count++;
                s++;
            }
            rooms = Math.max(rooms, count);
            while (s < n && e < n && ep[e] <= sp[s]){
                count--;
                e++;
            }
        }
        return rooms;
    }
}