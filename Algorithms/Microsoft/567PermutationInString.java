class Solution {
       public boolean checkInclusion(String s1, String s2) {
           int l1 = s1.length();
           int l2 = s2.length();
           int[] count = new int[26];
           if (l1 > l2){ return false; }
           for (int i = 0; i < l1; i++){
               count[s1.charAt(i) - 'a']++;
               count[s2.charAt(i) - 'a']--;
           }
           
           if (AllZeros(count)){
               return true;
           }
           
           for (int i = l1; i < l2; i++){
               count[s2.charAt(i) - 'a']--;
               count[s2.charAt(i - l1) - 'a']++;
               if (AllZeros(count)){
                   return true;
               }
           }
           return false;
           
       }
    
        
       private boolean AllZeros(int[] input){
           for (int val : input){
               if (val != 0){
                   return false;
               }
           }
           return true;
       }
}