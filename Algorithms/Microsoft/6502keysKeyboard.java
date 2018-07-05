class Solution {
    public int minSteps(int n) {
        int sum = 0;
        for (int step = 2; step <= n; step++){
            while (n % step == 0){
                sum += step;
                n /= step;
            }
        }
        return sum;
    }
}