public class PrimesInSubtree {
    static List<Integer> primeQuery(int n, List<Integer> first, List<Integer> second, List<Integer> values, List<Integer> queries) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < first.size(); i++){
            if (!graph.containsKey(first.get(i))){
                graph.put(first.get(i), new HashSet<>());
            }
            graph.get(first.get(i)).add(second.get(i));
            if (!graph.containsKey(second.get(i))){
                graph.put(second.get(i), new HashSet<>());
            }
            graph.get(second.get(i)).add(first.get(i));
        }
        
        dfsSearch(graph, -1, 1);
        int[] cnts = new int[n + 1];
        Arrays.fill(cnts, -1);
        List<Integer> res = new ArrayList<>();
        for(int q : queries){
            if (cnts[q] == -1){
                res.add(dfsUpdateCnt(graph, q, cnts, values));
            } else {
                res.add(cnts[q]);
            }
        }
        return res;
    }
    
    static int dfsUpdateCnt(Map<Integer, Set<Integer>> graph, int cur, int[] cnts, List<Integer> values){
        if (cnts[cur] == -1){
            cnts[cur] = 0;
            for (int next : graph.get(cur)){
                cnts[cur] += dfsUpdateCnt(graph, next, cnts, values);
            } 
            if (isPrime(values.get(cur - 1))){
                cnts[cur] += 1;
            }
        }
        return cnts[cur];
    }

    static void dfsSearch(Map<Integer, Set<Integer>> graph, int parent, int cur){
        for (int next : graph.get(cur)){
            if (parent != next){
                dfsSearch(graph, cur, next);
            }
        }
        graph.get(cur).remove(parent);
    }

    static boolean isPrime(int val){
        if(val == 1){return false; }
        if(val <= 3){return true; }
        if (val % 2 == 0){return false; }
        for (int i = 2; i * i <= val; i++){
            if (val % i == 0){
                return false;
            }
        }
        return true;
    }

    static void printList(List<Integer> list){
        for (int num : list){
            System.out.print(num+", ");
        }
        System.out.println("");
    }

    static void printArray(int[] list){
        for (int num : list){
            System.out.print(num+", ");
        }
        System.out.println("");
    }
}
