/**     0  1  2
        1  2  3
           4  5
           -----
           1  5  
        1  0
      0 5
        1  2
      0 8          
    0 4
---------------------
    0 1 2  3  4  
*/

nums1 i * num2 j  => i+j, i+j+1;


class Solution {
    public String multiply(String num1, String num2) {
        if (num1.isEmpty()){
            return num2;
        }
        if (num2.isEmpty()){
            return num1;
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int[] res = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--){
            for (int j = l2 - 1; j >= 0; j--){
                int multi = (num1.charAt(l1) - '0') * (num2.charAt(l2) - '0');
                int p1 = l1 + l2;
                int p2 = l1 + l2 + 1;
                
                int sum = multi + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < res.length; i++){
            if (i == 0 && res[0] == 0){
                continue;
            }
            ans.append(res[i]);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}