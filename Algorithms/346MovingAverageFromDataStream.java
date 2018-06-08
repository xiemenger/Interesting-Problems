class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> q;
    double avg;
    double sum;
    int s;
    public MovingAverage(int size) {
        q = new LinkedList<>();
        avg = 0;
        s = size;
    }
    
    public double next(int val) {
        q.add(val);
        sum += val;
        if(q.size() > s){
            int last = q.poll();
            sum -= last;
        }
        avg = sum / q.size();
        return avg;
    }
}