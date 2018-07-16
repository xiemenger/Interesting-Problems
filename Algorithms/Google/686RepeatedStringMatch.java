class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        int count = 1;
        int maxCount = (B.length() / A.length()) + 2;
        while (sb.length() < B.length() || (count <=  maxCount && sb.toString().indexOf(B) < 0)){
            count++;
            sb.append(A);
        }
        
        if (count <= maxCount){
            return count;
        }
        return -1;
    }
}