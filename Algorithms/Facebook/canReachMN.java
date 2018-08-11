class solution{
    public boolean canReachMN(int m, int n){
        if (m == 1 && n == 1){return true;}
        int[] num = new int[]{m, n};
        while (num[0] >= 1 && num[1] == 1){
            previousPos(num);
            if (num[0] == 1 && num[1] == 1){
                return true;
            }
        }
        return false;
    }

    private void previousPos(int[] cur){
        if (cur[1] > cur[0]){
            cur[1] -= cur[0];
        } else {
            cur[0] -= cur[1];
        }
    }
}