/**
 * three case:
 * 1. two rectanle intersects.
 * 2. one rectangle is inside of another.
 * 3. no overlap.
 */

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x1 = Math.max(A, E);
        int y1 = Math.max(B, F);
        int x2 = Math.max(x1, Math.min(C, G));
        int y2 = Math.max(y1, Math.min(D, H));
        
        int inter = (x2 - x1) * (y2 - y1);
        int total = (C - A) * (D - B) + (G - E) * (H - F);
        return total - inter;
    }
}