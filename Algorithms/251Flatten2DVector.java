public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> it1;
    private Iterator<Integer> it2;
    public Vector2D(List<List<Integer>> vec2d) {
        it1 = vec2d.iterator();
    }

    @Override
    public Integer next() {
        hasNext();
        return it2.next();
    }

    @Override
    public boolean hasNext() {
        while((it2 == null || !it2.hasNext()) && it1.hasNext()){
            it2 = it1.next().iterator();
        }
        return it2 != null && it2.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */