class Solution {
    public NestedInteger deserialize(String s) {
        if (s.isEmpty()){
            return null;
        }
        if (s.charAt(0) != '['){
            return new NestedInteger(Integer.valueOf(s));
        }
        NestedInteger cur = null;
        Stack<NestedInteger> stack = new Stack<>();
        int n = s.length();
        int l = 0;
        for (int r = 0; r < n; r++){
            char c = s.charAt(r);
            if (c == '['){
                if (cur != null){
                    stack.push(cur);
                }
                cur = new NestedInteger();
                l = r + 1;
            } else if (c == ']'){
                String num = s.substring(l, r);
                if (!num.isEmpty()){
                    cur.add(new NestedInteger(Integer.valueOf(num)));
                }
                if (!stack.isEmpty()){
                    NestedInteger pre = stack.pop();
                    pre.add(cur);
                    cur = pre;
                }
                l = r + 1;
            } else if (c == ','){
                if (s.charAt(r - 1) != ']'){
                    String num = s.substring(l, r);
                    cur.add(new NestedInteger(Integer.valueOf(num)));
                }
                l = r + 1;
            }
        }
        return cur;
    }
}