class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y){ return false; }
        if (z == x || z == y || z == (x + y)){
            return true;
        }
        int f = gcd(x, y);
        return z % f == 0;
    }
    
    public int gcd(int x, int y){
        if (y == 0){ return x; }
        return gcd(y, x % y);
    }
}