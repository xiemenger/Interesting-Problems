class Solution {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int bull = 0;
        int cow = 0;
        
        for(int i = 0; i < guess.length(); i++){
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i)-'0';
            if (s == g){
                bull++;
            } else {
                if (count[s] < 0){ cow++; }
                if (count[g] > 0){ cow++; }
                count[s]++;
                count[g]--;
            }
        }
        return ""+bull+"A"+cow+"B";
    }
}