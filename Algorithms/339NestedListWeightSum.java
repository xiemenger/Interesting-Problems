class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return Sum(nestedList, 1);
    }
    
    public int Sum(List<NestedInteger> nestedList, int depth){
        int sum = 0;
        for (NestedInteger cur : nestedList){
            if (cur.isInteger()){
                sum += cur.getInteger()*depth;
            } else {
                sum += Sum(cur.getList(), depth+1);
            }
        }
        return sum;
    }
}