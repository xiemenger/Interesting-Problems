class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        int res = 0;
        for (String token : tokens){
            switch(token){
                case "+":
                    nums.push(nums.pop() + nums.pop());
                    break;
                
                case "-":
                    nums.push(-nums.pop() + nums.pop());
                    break;
                    
                case "*":
                    nums.push(nums.pop() * nums.pop());
                    break;
                
                case "/":
                    int b = nums.pop();
                    int a = nums.pop();
                    nums.push(a/b);
                    break;
                
                default:
                    nums.push(Integer.parseInt(token));
            }
        }
        
        for (int num : nums){
            res += num;
        }
        return res;
    }
}