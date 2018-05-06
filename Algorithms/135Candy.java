class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length <= 1){
            return ratings.length;
        }
        int sum = 0;
        int[] candies = new int[ratings.length];
        for (int i = 0; i < candies.length; i++){
            candies[i] = 1;
        }
        
        // From left to right
        for (int i = 1; i < ratings.length; i++){
            if (ratings[i] > ratings[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // From right to left
        sum += candies[candies.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--){
            if (ratings[i] > ratings[i + 1]){
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        
        return sum;  
    }
}