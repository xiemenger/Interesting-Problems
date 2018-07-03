/**
 * Instead of comparing people, we can compare ages.
 * ages cover from 0 ~ 120 inclusive.
 */

class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age : ages){
            count[age]++;
        }
        
        int res = 0;
        for (int ageA = 0; ageA <= 120; ageA++){
            if (count[ageA] == 0){ continue; }
            for (int ageB = 0; ageB <= 120; ageB++){
                if (count[ageB] == 0){ continue; }
                if (ageB > ageA) { continue; }
                if (ageB <= ageA / 2 + 7){ continue; }
                if (ageB > 100 && ageA < 100){ continue; }
                res += count[ageA] * count[ageB];
                if (ageA == ageB){
                    res -= count[ageA];
                }
            }
        }
        return res;
    }
}