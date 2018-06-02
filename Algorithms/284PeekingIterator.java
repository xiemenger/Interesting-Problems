class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer top;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it = iterator;
        if(it.hasNext()){
            top = it.next(); 
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return top;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        int tmp = top;
        if (it.hasNext()){
            top = it.next();
        } else {
            top = null;
        }
	    
        return tmp;
	}

	@Override
	public boolean hasNext() {
	    return top != null;
	}
}