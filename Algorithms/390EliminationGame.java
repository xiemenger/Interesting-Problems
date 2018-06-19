class Solution {
    public int lastRemaining(int n) {
        int dist = 1;
        int head = 1;
        boolean left = true;
        while (n > 1){
            
            if (left || n % 2 == 1){
                head = head + dist;
            }
            left = !left;
            dist *= 2;
            n /= 2;
            
        }
        return head;
    }
}