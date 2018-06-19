class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> nums = new Stack<>();
        Stack<String> str = new Stack<>();
        int i = 0;
        while (i < s.length()){
            char cur = s.charAt(i);
            int num = 0;
            if (cur <='9' && cur >= '0' ){
                while (i < s.length() && s.charAt(i) <='9' && s.charAt(i) >= '0'){
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                nums.push(num);
            } else if (cur == '['){
                str.push(res);
                res = "";
            } else if (cur == ']'){
                StringBuilder sb = new StringBuilder(str.pop());
                int times = nums.pop();
                while (times-- > 0){
                    sb.append(res);
                }
                res = sb.toString();
            } else {
                res += s.charAt(i);
            }
            i++;
        }
        return res;
    }
}