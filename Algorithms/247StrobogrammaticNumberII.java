class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0){ return res; }
        if (n == 1 || n % 2 == 1){
            res = new ArrayList<>(Arrays.asList("0", "1", "8"));
        }
        if (n == 2 || n % 2 == 0){
            res = new ArrayList<>(Arrays.asList("11", "88", "69", "96"));
        }
        
        if (n > 3 && n % 2 == 0){
            res.add("00");
        }
        int i = 3;
        
        while (i <= n){
            ArrayList<String> tmp = new ArrayList<>();
            for (String s : res){
                if (i != n && i+1 != n){
                    tmp.add("0"+s+"0");
                }
                tmp.add("1"+s+"1");
                tmp.add("8"+s+"8");
                tmp.add("6"+s+"9");
                tmp.add("9"+s+"6");
            }
            i += 2;
            res = tmp;
        }
        return res;
    }
}