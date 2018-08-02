/**
 * 
 * 
 */
class solution{
    private void mergeTwoIntervalList(Interval[] l1, Interval[] l2) {
		if (l1 == null) {return; }
		if (l2 == null) {return;}
		int idx1 = 0;
		int idx2 = 0;
		List<Interval> res = new ArrayList<>();
		while (idx1 < l1.length && idx2 < l2.length) {
			if (l1[idx1].end < l2[idx2].start) {
				check(res, l1[idx1]);
				idx1++;
			} else if (l2[idx2].end < l1[idx1].start) {
				check(res, l2[idx2]);
				idx2++;
			} else {
				int start = Math.min(l1[idx1].start, l2[idx2].start);
				int end = Math.max(l1[idx1].end, l2[idx2].end);
				Interval cur = new Interval(start, end);
				idx1++;
				idx2++;
				check(res, cur);
			}
			
		}
		while (idx1 < l1.length) {
			check(res, l1[idx1++]);
		}
		while (idx2 < l2.length) {
			check(res, l2[idx2++]);
		}
		
		for (Interval i : res) {
			System.out.print("["+i.start+","+i.end+"]  ");
		}
		
	}
	
	private static void check(List<Interval> res, Interval cur) {
		if (res.size() == 0) {
			res.add(cur);
			return;
		}
		Interval last = res.get(res.size() - 1);
		if (last.end < cur.start) {
			res.add(cur);
		} else {
			last.start = Math.min(last.start, cur.start);
			last.end = Math.max(last.end, cur.end);
		}
	}

}