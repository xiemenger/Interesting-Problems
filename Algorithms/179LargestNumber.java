class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            str[i] = String.valueOf(nums[i]);
        }
        
        Comparator<String> comp = new Comparator<String>(){
            // override
            public int compare(String s1, String s2){
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str2.compareTo(str1);
            }
        };
        
        Arrays.sort(str, comp);
        if (str[0].charAt(0) == '0'){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s : str){
            sb.append(s);
        }
        return sb.toString();
    }
}