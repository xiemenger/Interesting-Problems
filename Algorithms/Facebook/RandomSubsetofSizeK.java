/**
 * Give a num stream, very long
 * random select k numbers from it with same prosibility,
 * 
 * 
 * 
 * solution:
 * Resivoir Algorithm
 * 我们的resivoir size是k, 最终要保证每个resevior里的数被取到的概率都是k / n;
 * for every stream[i], 产生一个随机值 idx, if idx < k, resevior[idx] = nums[i]
 * 
 *  
 * 1. 先创建res[] 长度为K,
 *    先把前k个数放到resevior里去.
 *    然后i 开始从 k 遍历. 
 *    对于每个i, 产生一个idx, 如果这个idx < k, 我们认为他是candidate.
 *     res[idx] = nums[i];
 *      
 * 证明:
 * 先考虑stream里的最后一个数字:stream[n - 1]的prob 是 k / n;
 * 在看stream 倒数第二个数字: stream[n - 2]
 *            他最终在resevior的概率等于: 他在n - 2时 产生的j < k: (k / n - 1)
 *             乘于 在n - 1时, 下一个数产生的idx 不和他的index相同:  (n - 1 / n)
 *             =   k         n - 1      k
 *               -----  *  --------  = ---
 *               n - 1         n        n
 * 
 */
class Solution{
    public int[] selectKItems(int[] stream, int k){
        Rnadom r = new Random();
        int[] resevior = new int[k];
        for (int i = 0; i < k; i++){
            resevior[i] = stream[i];
        }
        for (int i = k; i < stream.length; i++){
            int idx = rand.nextInt(i+1);
            if (idx < k){
                resevior[idx] = stream[i];
            }
        }
        return resevior;
    }
}