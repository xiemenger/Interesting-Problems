class Solution {
    public List<String> removeComments(String[] source) {
        boolean blockopen = false;
        List<String> res = new ArrayList<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (String s : source){
            int n = s.length();
            for (int j = 0; j < n; j++){
                if (blockopen){
                    if (s.charAt(j) == '*' && j < n - 1 && s.charAt(j + 1) == '/'){
                        j++;
                        blockopen = false;
                    }
                } else {
                    if (s.charAt(j) == '/' && j < n - 1 && s.charAt(j + 1) == '/'){
                        break;
                    } else if (s.charAt(j) == '/' && j < n - 1 && s.charAt(j + 1) == '*'){
                        blockopen = true;
                        j++;
                    } else {
                        sb.append(s.charAt(j));
                    }
                }
            }
            if (!blockopen && sb.length() > 0){
                res.add(sb.toString());
                sb = new StringBuilder();
            }
            i++;
        }
        return res;
    }
}