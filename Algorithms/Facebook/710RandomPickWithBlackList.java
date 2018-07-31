/**
    解题思路是: 把所有(0 到 N - b.length)的里 在blacklist里的数字,全部match到b.lenth() - N里的非blacklist的数字.
    这样我们随机的取0 - N-b.length的数字就好, 如果取到了blacklist里的数字, 就去拿match的数字.
    
    code主要有三步:
    1. 把wlen - N的数字全部放到set里.
    2. 在set里把black num去掉. 剩下的所有的是white num
    3. 走一遍black num, 把小于wlen的black num match到 set里的white num.

    O(B), O(B)
*/

class Solution {
    Map<Integer, Integer> blackToWhite;
    Random rand;
    int wlen;
    public Solution(int N, int[] blacklist) {
        blackToWhite = new HashMap();
        rand = new Random();
        Set<Integer> validNumLargerThanWL = new HashSet();
        
        wlen = N - blacklist.length;
        for (int i = wlen; i < N; i++){
            validNumLargerThanWL.add(i);
        }
        
        for (int b : blacklist){
            validNumLargerThanWL.remove(b);
        }
        
        for (int a : validNumLargerThanWL){
            System.out.print(a+" ");
        }
        Iterator<Integer> wi = validNumLargerThanWL.iterator();
        
        for (int b : blacklist){
            if (b < wlen){
                blackToWhite.put(b, wi.next());
            }
        }
    }
    
    public int pick() {
        int num = rand.nextInt(wlen);
        return blackToWhite.getOrDefault(num, num);
        
    }
}