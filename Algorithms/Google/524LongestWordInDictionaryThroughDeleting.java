class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String w : d){
            int iw =0;
            for (char c : s.toCharArray()){
                if (iw < w.length() && w.charAt(iw) == c){
                    iw++;
                }
            }
            
            if(iw != w.length()){
                continue; 
            }
                
             if (res.length() < w.length() || (res.length() == w.length() && res.compareTo(w) > 0)){
               res = w;
            }
        }
        
        return res;
    }
}