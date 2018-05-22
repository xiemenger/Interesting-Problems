class Solution {
    public int calculate(String s) {
        if (s.isEmpty()){
            return 0;
        }
        int n = s.length();
        int sum = 0;
        int num = 0;
        int preSign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            char cur = s.charAt(i);
            if (Character.isDigit(cur)){
                num = num * 10 + (cur - '0');
            } 
            if (i == n - 1 || 
                (!Character.isDigit(cur) && cur != ' ')){
               if (preSign == '+'){
                   stack.push(num);
               } else if (preSign == '-'){
                   stack.push(-num);
               } else if (preSign == '*'){
                   stack.push(stack.pop() * num);
               } else {
                   stack.push(stack.pop() / num);
               }
                num = 0;
                preSign = cur;
            }
        }
        
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}