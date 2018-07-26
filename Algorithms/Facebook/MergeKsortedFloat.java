public class MergeKSortArrayDouble {
	public static void main(String[] args) {
		float[] data = new float[] {1.0f, 2f, 6f, 1.2f, 6f, 5f, 9.0f, 2.3f, 3f, 5f, 6f};
		for (float f : data) {
			System.out.print(f+" ");
		}
		System.out.println("");
		mergeKDouble(data);
		for (float f : data) {
			System.out.print(f+" ");
		}
	}
	
	private static void mergeKDouble(float[] data) {
        List<Node> heads = new ArrayList<>();
		PriorityQueue<Node> minQueue = new PriorityQueue<>((a, b) -> (Double.compare(a.value, b.value)));
		Node prev = null;
		for (int i = 0; i < data.length; i++) {
			Node node = new Node(data[i]);
			if (prev == null || data[i - 1] > data[i]) {
				heads.add(node);
			} else {
				prev.next = node;
			}
			prev = node;
		}
		
		for (Node node : heads) {
			minQueue.add(node);
		}
        
		int idx = 0;
		while (!minQueue.isEmpty()) {
            Node cur = minQueue.poll();
			data[idx++] = cur.value;
            if (cur.next != null){
                minQueue.add(cur.next);
            }
		}
		
	}

}

class Node {
	float value;
	Node next;
	
	public Node(float value) {
		this.value = value;
	}
}