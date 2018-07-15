class Solution {
    public String nextClosestTime(String time) {
        Set<Integer> digits = new HashSet<>();
        String[] t = time.split(":");
        int hour = Integer.valueOf(t[0]);
        int minute = Integer.valueOf(t[1]);
        
        digits.add(hour / 10);
        digits.add(hour % 10);
        digits.add(minute / 10);
        digits.add(minute % 10);
        int[] tt = new int[]{hour, minute};
        
        do {
            next(tt);
        } while (!isValid(digits, tt));
        
        return String.format("%02d:%02d", tt[0], tt[1]);
        
    }
    
    private void next(int[] t){
        t[1]++; // minute increase by 1;
        if (t[1] == 60){
            t[1] = 0;
            t[0]++;
            if (t[0] == 24){
                t[0] = 0;
            }
        }
    }
    
    private boolean isValid(Set<Integer> digits, int[] t){
        return digits.contains(t[0] / 10) 
            && digits.contains(t[0] % 10)
            && digits.contains(t[1] / 10)
            && digits.contains(t[1] % 10);
    }
}