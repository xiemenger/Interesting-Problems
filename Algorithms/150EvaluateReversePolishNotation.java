class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null){
            return 0;
        }
        Stack<Integer> stack = new Stack();
        int a = 0;
        int b = 0;
        for (String str : tokens){
            switch(str){
                case "+":
                stack.push(stack.pop() + stack.pop()); 
                break;
                
                case "-":
                 b = stack.pop();
                 a = stack.pop();
                stack.push(a - b);
                break;
                
                case "*":
                stack.push(stack.pop() * stack.pop());
                break;
                
                case "/":
                 b = stack.pop();
                 a = stack.pop();
                stack.push(a / b);
                break;
                
                default:
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }
}