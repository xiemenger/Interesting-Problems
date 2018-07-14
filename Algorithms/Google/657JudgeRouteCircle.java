class Solution {
    public boolean judgeCircle(String moves) {
        int horizontal = 0;
        int vertical = 0;
        
        for (char c : moves.toCharArray()){
            switch (c) {
                case 'R': horizontal++; break;
                case 'L': horizontal--; break;
                case 'U': vertical++; break;
                case 'D': vertical--; break;
            }
        }
        
        return vertical == 0 && horizontal == 0;
    }
}