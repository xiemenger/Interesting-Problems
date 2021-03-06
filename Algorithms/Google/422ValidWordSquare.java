class Solution {
    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        for (int i = 0; i < n; i++){
            int m = words.get(i).length();
            for (int j = 0; j < m; j++){
                if(n < m || words.get(j).length() <= i 
                   || words.get(i).charAt(j) != words.get(j).charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}