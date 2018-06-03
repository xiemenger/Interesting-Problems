class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> Largers;
    PriorityQueue<Integer> Smallers;
    public MedianFinder() {
        Largers = new PriorityQueue<>();
        Smallers = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        
        
    }
    
    public void addNum(int num) {
        Smallers.offer(num);
        Largers.offer(Smallers.poll());
        if (Smallers.size() < Largers.size()){
            Smallers.offer(Largers.poll());
        }
    }
    
    public double findMedian() {
        if (Smallers.size() > Largers.size()){
            return Smallers.peek();
        } else {
            return (Smallers.peek() + Largers.peek()) / 2.0;
        }
    }
}