public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >=0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (hasNext()){
            return stack.pop().getInteger();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()){
            NestedInteger cur = stack.peek();
            if (cur.isInteger()){
                return true;
            } 
            
            cur = stack.pop();
            for (int i = cur.getList().size() - 1; i >=0 ; i--){
                stack.push(cur.getList().get(i));
            }
            
        }
        return false;
    }
}