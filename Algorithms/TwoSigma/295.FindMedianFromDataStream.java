class MedianFinder {

    /** initialize your data structure here. */
    private Queue<Integer> smallers;
    private Queue<Integer> largers;
    
    public MedianFinder() {
        smallers = new PriorityQueue<>();
        largers = new PriorityQueue<>((a, b) -> (b - a));
    }
    
    public void addNum(int num) {
        smallers.offer(num);
        largers.offer(smallers.poll());
        if (smallers.size() < largers.size()){
            smallers.offer(largers.poll());
        }
    }
    
    public double findMedian() {
        if (smallers.size() > largers.size()){
            return smallers.peek();
        } else {
            return (smallers.peek() + largers.peek()) / 2.0;
        }
    }
}