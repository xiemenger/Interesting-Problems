class Solution {
    public String simplifyPath(String path) {
        String[] str = path.split("/");
        List<String> list = new ArrayList<>();
        for (String s : str){
            if (s.isEmpty() || s.equals(".")){
                continue;
            }  
            
            if (s.equals("..")){
                if (list.size() != 0){
                   list.remove(list.size() - 1);
                }
            } else {
                list.add(s);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (String cur : list){
            sb.append("/");
            sb.append(cur);
        }
        return sb.length() <= 1 ? "/" : sb.toString();    
    }
}