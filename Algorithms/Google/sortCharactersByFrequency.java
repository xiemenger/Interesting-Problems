class Solution {
    public String frequencySort(String s) {
        int[][] count = new int[256][2];
        for (char c : s.toCharArray()){
            count[c][0] = c;
            count[c][1]++;
        }
        
        Arrays.sort(count, (a, b) -> (b[1] - a[1]));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++){
            if (count[i][1] > 0){
                char cur = (char)count[i][0];
                for (int j = count[i][1]; j > 0; j--){
                    sb.append(cur);
                }
            }
        }
        return sb.toString();
    }
}