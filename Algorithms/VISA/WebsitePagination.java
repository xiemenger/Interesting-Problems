public class WebsitePagination {
	public static void main(String[] args) {
		String[][] items = new String[][] {{"item1", "10", "15"},
										  {"item2", "3", "4"},
										  {"item3", "17", "8"}};
		List<String> res = fetchItemsToDisplay(items, 1, 1, 2, 2);							  
		for (String r : res) {
			System.out.print(r+" ,");
		}
	}
	
	
	private static List<String> fetchItemsToDisplay(String[][] items, int sp, int so, int x, int y){
		List<String> res = new ArrayList<>();
		if (x * y >= items.length) {return res; }
		Arrays.sort(items, new Comparator<String[]>() {
			public int compare(String[] a, String[] b) {
					if (sp == 0) {
						return so == 0 ? a[0].compareTo(b[0]) : b[0].compareTo(a[0]); 
						}
					else {
						return so == 0 ? Integer.parseInt(a[sp]) - Integer.parseInt(b[sp]) :
							             Integer.parseInt(b[sp]) - Integer.parseInt(a[sp]);
					}
			}
		});
		
		int start = y * x;
		int end = start + x;
		for (; start < end && start < items.length; start++) {
			res.add(items[start][0]);
		}
		return res;
	}

}
