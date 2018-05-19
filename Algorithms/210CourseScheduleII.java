class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        Queue<Integer> zeorIndegree = new LinkedList<>();
        int courseCount = 0;
        int[] res = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        
        // create graph
        for (int[] pre : prerequisites){
            map.get(pre[1]).add(pre[0]);
            indegrees[pre[0]]++;
        }
        
        // queue gets all courses which has zero indegress;
        for (int i = 0; i < numCourses; i++){
            if (indegrees[i] == 0){
                zeorIndegree.offer(i);
            }
        }
        
        while (!zeorIndegree.isEmpty()){
            int curCourse = zeorIndegree.poll();
            res[courseCount] = curCourse;
            courseCount++;
            
            for (int course : map.get(curCourse)){
                indegrees[course]--;
                if (indegrees[course] == 0){
                    zeorIndegree.offer(course);
                }
            }
            map.remove(curCourse);
        }
        
        return courseCount == numCourses ? res : new int[0];
    }
}