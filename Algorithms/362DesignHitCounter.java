class HitCounter {

    /** Initialize your data structure here. */
    int[] hits;
    int[] time;
    int TIMERANGE = 300;
    public HitCounter() {
        
        hits = new int[TIMERANGE];
        time = new int[TIMERANGE];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int idx = timestamp % TIMERANGE;
        if (time[idx] != timestamp){
            hits[idx] = 0;
        }
        hits[idx]++;
        time[idx] = timestamp;
        
    }    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count  = 0;
        for (int i = 0; i < TIMERANGE; i++){
            if (timestamp - time[i] >= 0 && timestamp - time[i] < TIMERANGE){
                count += hits[i];
            }
        }
        return count;
    }
}