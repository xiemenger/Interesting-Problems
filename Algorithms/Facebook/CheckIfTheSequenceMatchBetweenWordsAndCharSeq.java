/**
Given an String array A ["cat", "bat", "dog", "zip", "face"]
and a char array B ['c','b','d','a','f']
question : is A sorted according to B?

e.g.
A ["cat", "bat", "dog", "zip", "face"]
B ['c','b','d','z','f']
return true;

A ["cat","cataa", "bat", "dog", "zip", "face"]
B ['c','b','d','z','f']
return true;


A ["bat", "cat", "dog", "zip", "face"]
B ['c','b','d','z','f']
 return false;
*/

/**
1. questions: if the first differe chars are in the correct sequence. do i 
   need to continue comparing, or can stop?
2. if the alphabet has duplicates or not.
3. if the length are different, but the chars are in correct sequences.
4. 
*/

class solution{
    public static void main(String[] args){
        String[] words = new String[]{"dog", "cat", "dot", "cab", "doggy"};
        char[] alphabet = new char[]{'t', 'd', 'c','b'};
        checkSequence(words, alphabet);
    }

    private static boolean checkSequence(String[] words, char[] alphabet){
        Map<Character, Integer> indices = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++){
            indices.put(alphabet[i], i);
        }

        for (int i = 0; i < words.length - 1; i++){
            Stirng curWord = words[i];
            String nextWord = words[i + 1];
            int len = Math.min(curWord.length(), nextWord.length());
            for (int j = 0; j < len; j++){
               char curChar = curWord.charAt(j);
               char nextChar = nextWord.charAt(j);
               if (curChar == nextChar){
                   continue;
               }
               if (indices.get(curChar) < indices.get(nextChar)){
                   System.out.println(curWord+"  "+nextWrod+ " does not match");
                   System.out.println("   return false");
                   return false;
               } else {
                    System.out.println(curWord+"  "+nextWrod+ "  matches");
                   break;
               }
            }
        }
        System.out.println("  All words matches,  return true");
        return true;
    }


    private boolean isSortedArray(String[] words, char[] aphabet) {   
        Map<Character, Integer> indices = new HashMap<>(); 
        for (int i = 0; i<aphabet.length; i++ ) { 
            indices.put(aphabet, i);                
        }                                
        for (int i = 1; i < words.length; i++ ) {                        
            String pre = words[i-1];                        
            String cur = words;                                                
            int minLen = Math.min(pre.length(), cur.length());                        
            boolean isSorted = false;                        
            for (int j = 0; j < minLen; j++ ) {                                
                int preIndex = indices.get(pre.charAt(j));                                
                int curIndex = indices.get(cur.charAt(j));                                                                
                if ( preIndex > curIndex) {                                                                                
                    return false;                                
                } else if (preIndex < curIndex) {                                        
                    isSorted = true;                                        
                    break;                                
                }                        
            }                        
            if (!isSorted && pre.length() > cur.length()) 
            return false;                
        }                                
        return true;        
    }
}