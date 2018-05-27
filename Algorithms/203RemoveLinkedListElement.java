/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        while (head != null){
            if (head.val == val){
                pre.next = head.next;
                head = class Solution {
                    public List<List<Integer>> fourSum(int[] nums, int target) {
                        List<List<Integer>> res = new ArrayList<>();
                        Arrays.sort(nums);
                        kSum(nums, 4, target, 0, res, new ArrayList<>());
                        return res;
                    }
                    
                    public void kSum(int[] nums, int k, int target, int start, List<List<Integer>> res, List<Integer> path){
                        //System.out.println("k="+k+"  start="+start);
                        if (nums == null || nums.length < k || nums[0] * k > target || nums[nums.length - 1] * k < target){
                            return;
                        }
                        
                        
                        // when k == 2
                        if (k == 2){
                            int l = start;
                            int r = nums.length - 1;
                            while (l < r){
                                if (nums[l] + nums[r] < target){
                                    l++;
                                } else if (nums[l] + nums[r] > target){
                                    r--;
                                } else {
                                    
                                    List<Integer> tmp = new ArrayList<>(path);
                                    tmp.add(nums[l]);
                                    tmp.add(nums[r]);
                                    res.add(tmp);
                                    l++;
                                    r--;
                                    while(l < r && nums[l] == nums[l - 1]){ l++; }
                                    while(l < r && nums[r] == nums[r + 1]){ r--; }
                                }
                                
                            }
                            return;
                        }
                        
                        // when k > 2
                        int max = nums[nums.length - 1];
                        for (int i = start; i < nums.length - k + 1; i++){
                            int c = nums[i];
                            if (i > start && c == nums[i - 1]) { continue; } // skip duplicate
                            if ((c + (k - 1)* max) < target){ continue; } // c is too small
                            if (c * k > target){ break; } // c is too large
                            if (c * k == target){
                                if (nums[i + k - 1] == c){
                                    List<Integer> tmp = new ArrayList<>(path);
                                    for (int j = 0; j < k; j++){
                                        tmp.add(c);
                                    }
                                    res.add(tmp);
                                }
                                break;
                            }
                            path.add(c);
                            kSum(nums, k - 1, target - c, i + 1, res, path);
                            path.remove(path.size() - 1);
                        }
                        
                    }
                }.next;
            } else {
                pre = head;
                head = head.next;
            }
        }
        return dummy.next;
    }
}