class Solution {
    public boolean isValid(String s) {
        Stack<Character> preChar = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                preChar.push(c);
            } else {
                if (preChar.isEmpty()){
                    return false;
                }
                
                if (c == ')'){
                    if (preChar.pop() != '('){
                        return false;
                    }
                }else if (c == ']'){
                    if (preChar.pop() != '['){
                        return false;
                    }
                } else {
                    if (preChar.pop() != '{'){
                        return false;
                    }                    
                }
            }        
        }
        return preChar.isEmpty();
    }
}