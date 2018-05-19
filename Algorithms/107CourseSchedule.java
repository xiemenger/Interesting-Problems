class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] degrees = new int[numCourses];
        Queue<Integer> zeroDegrees = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++){
             map.put(i, new ArrayList<>());
        }
        
        // compute map and degree
        for (int[] pre : prerequisites){
            map.get(pre[0]).add(pre[1]);
            degrees[pre[1]]++;
        }
        
        // offer zero degree courses
        for (int i = 0; i < numCourses; i++){
            if (degrees[i] == 0){
                zeroDegrees.offer(i);
            }
        }
        
        // sort graph
        int count = 0;
        while (!zeroDegrees.isEmpty()){
            count++;
            int curCourse = zeroDegrees.poll();
            degrees[curCourse] = -1;
            for (int preCourse : map.get(curCourse)){
                degrees[preCourse]--;
                if (degrees[preCourse] == 0){
                    zeroDegrees.offer(preCourse);
                }
            }
            map.remove(curCourse);
        }
        
        if (count == numCourses){
            return true;
        }
        return false;
    } 
}