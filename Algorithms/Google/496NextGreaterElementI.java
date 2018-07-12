class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // key:value = num:next larger num.
        Stack<Integer> stack = new Stack<>(); 
        for (int num : nums2){
            while (!stack.isEmpty() && num > stack.peek()){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        int[] res = new int[nums1.length];
        int i = 0;
        for (int num : nums1){
            res[i++] = map.getOrDefault(num, -1);
        }
        return res;
    }
}