class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int sum = 0;
        int cur = 0;
        while (!nestedList.isEmpty()){
            List<NestedInteger> nextLever = new ArrayList<>();
            for (NestedInteger node : nestedList){
                if (node.isInteger()){
                    cur += node.getInteger();
                } else {
                    nextLever.addAll(node.getList());
                }
            }
            sum += cur;
            nestedList = nextLever;
        }
        return sum;
    }
    
}