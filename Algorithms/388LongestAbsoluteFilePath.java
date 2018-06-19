class Solution {
    public int lengthLongestPath(String input) {
        int max = 0;
        Stack<Integer> layers = new Stack<>();
        layers.push(0);
        for (String s : input.split("\n")){
            int tlen = s.lastIndexOf("\t") + 1;
            while (layers.size() > tlen + 1){
                layers.pop();
            }
            int len = layers.peek() + s.length() - tlen + 1; 
            layers.push(len);
            //System.out.println(s+"  "+len);
            if (s.contains(".")){
                max = Math.max(len-1, max);
            }
            
        }
        return max;
    }
}