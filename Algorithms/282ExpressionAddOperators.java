class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num.isEmpty()){ return res; }
        find(num, target, 0, new StringBuilder(), 0, 0, res);
        return res;
    }
    
    public void find(String num, int target, int pos, StringBuilder path, long sum, long multi, List<String> res){
        if (pos == num.length()){
            if (sum == target){
                res.add(path.toString());
            }
        }
        
        for (int i = pos; i < num.length(); i++){
            if (i != pos && num.charAt(pos) == '0'){ break; }
            long cur = Long.parseLong(num.substring(pos,i+1));
            int len = path.length();
            if (pos == 0){
                
                find(num, target, i+1, path.append(cur), cur, cur, res);
                path.setLength(len);
            } else {
                find(num, target, i+1, path.append("+").append(cur), sum+cur, cur, res);
                path.setLength(len);
                find(num, target, i+1, path.append("-").append(cur), sum-cur, -cur, res);
                path.setLength(len);
                find(num, target, i+1, path.append("*").append(cur), sum-multi+multi*cur, multi*cur, res);
                path.setLength(len);
            }
        }
    }
}