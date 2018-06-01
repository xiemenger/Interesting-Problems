public class ZigzagIterator {
    LinkedList<Iterator> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<>();
        if (!v1.isEmpty()) { list.add(v1.iterator()); }
        if (!v2.isEmpty()){ list.add(v2.iterator()); }
    }

    public int next() {
        Iterator cur = list.poll();
        int res = (Integer)cur.next();
        if (cur.hasNext()){
            list.add(cur);
        }
        return res;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
