class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.max(left, Math.min(C, G));
        int bottom = Math.max(B, F);
        int up = Math.max(bottom, Math.min(D, H));
        
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        int commonarea = (right - left) * (up - bottom);
        
        return area1 + area2 - commonarea;
    }
}