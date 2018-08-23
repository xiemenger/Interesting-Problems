class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S.isEmpty()){
            return res;
        }
        int[] lastIdx = new int[26];
        for (int i = 0; i < S.length(); i++){
            lastIdx[S.charAt(i) - 'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++){
            end = Math.max(end, lastIdx[S.charAt(i) - 'a']);
            if (i == end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}