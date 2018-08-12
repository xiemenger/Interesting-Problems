class tasks{
 // without reorder, output the slots time we need to run the sheduler
 //  example:
// [1,2,1,3,4], interval time is 2, 
// output should be 9       1 2 _ 1 _ _1 3 4
public class FBTaskScheduler {

	private  int taskSchedule1(int[] tasks, int cooldown){
        if (tasks == null || tasks.length == 0){
            return 0;
        }
        Map<Integer, Integer> nextPos = new HashMap<>();
        int slots = 0;
        for (int task : tasks){
            if (nextPos.containsKey(task) && nextPos.get(task) > slots){
                slots = nextPos.get(task);
            }
            slots++;
            nextPos.put(task, slots + cooldown);
        }
        System.out.println(slots);
        return slots;
    }


/**
 * If we want to output the string
 * 
 */

  private  String taskSchedule2(int[] tasks, int cooldown){
    if (tasks == null || tasks.length == 0){
        return "";
    }
    Map<Integer, Integer> nextPos = new HashMap<>();
    int slots = 0;
    StringBuilder res = new StringBuilder();
    for (int task : tasks){
        while (nextPos.containsKey(task) && nextPos.get(task) > slots){
            res.append("_");
            slots++;
        }
        res.append(task);
        slots++;
        nextPos.put(task, slots + cooldown);
    }
    System.out.println(res.toString());
    return res.toString();
  }

  /**
   * you can reorder the input, compute the minimum slots to finish all tasks
   */
  private  int taskScheduler3(int[] tasks, int cooldown) {
	    if (tasks == null || tasks.length == 0){
	        return 0;
	    }
	    Map<Integer, Integer> freqs = new HashMap<>();
	    int rows = 0;
	    for (int task : tasks) {
	    	    int cnt = freqs.getOrDefault(task, 0) + 1;
	    		freqs.put(task, cnt);
	    		rows = Math.max(rows, cnt);
	    }
	    rows -= 1;
	    int idles = rows * (cooldown + 1);
	    for (int freq : freqs.values()) {
	    	idles -= Math.min(rows, freq);
	    }
	    return idles > 0 ? idles + tasks.length : tasks.length;
  }
  
  
}

}