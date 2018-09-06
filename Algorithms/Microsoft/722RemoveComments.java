/**
    for each line,  if the intial state is not in a block, start a new line in the res. 
    
    1) if not in a block: meet "/*"  state is changed to BLOCK, skip two characters.
    2) else if in a block: meet "* /", state is chanted to NotBlock.skip two characters.
    3) else if not in a block: meet "//", ingore the rest chars in the line. 
    4) else if not in a block, append it to the line.

    after scan the line, we check if we are in the block, if not, put the line into res.
    otherwise, we continue to scan the next line.
    
    Time: O(n) , n is the number of characters in the input.
    Space: O(1). 
*/

class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        if (source == null || source.length == 0){
            return res;
        }
        boolean inblock = false;
        StringBuilder line = new StringBuilder();
        for (String s : source){
            int i = 0; 
            int n = s.length();
            if (!inblock){
                line = new StringBuilder();
            }
            
            while (i < n){
                if (!inblock && i + 1 < n && s.charAt(i) == '/' && s.charAt(i + 1) == '*'){
                    inblock = true;
                    i++;
                } else if (inblock && i + 1 < n && s.charAt(i) == '*' && s.charAt(i + 1) == '/'){
                    inblock = false;
                    i++;
                } else if (!inblock && i + 1 < n && s.charAt(i) == '/' && s.charAt(i + 1) == '/'){
                    break;  
                } else if (!inblock){
                    line.append(s.charAt(i));
                }
                i++;
            }
            if (!inblock && line.length() > 0){
                res.add(line.toString());
            }
        }
        return res;
    }
}