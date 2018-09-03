class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> data;
    int s;
    double sum;
    public MovingAverage(int size) {
        data = new ArrayDeque<>();
        s = size;
        sum = 0;
    }
    
    public double next(int val) {
       data.offer(val);
        sum += val;
        if (data.size() > s){
            sum -= data.poll();
        }
        return sum /data.size();
    }
}