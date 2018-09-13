import java.util.HashMap;
import java.util.Map;

public class RoverControl {
    private static int roverMove(int size, String[] cmds) {
        // initialize
        int[] start = {0, 0};
        Map<String, int[]> map = new HashMap<>();
        map.put("UP", new int[]{-1, 0});
        map.put("DOWN", new int[]{1, 0});
        map.put("RIGHT", new int[]{0, 1});
        map.put("LEFT", new int[]{0, -1});

        // loop for the cmd
        for (String cmd : cmds) {
            int[] operation = map.get(cmd);
            if (start[0] + operation[0] < 0 
                || start[0] + operation[0] >= size
                || start[1] + operation[1] < 0 
                || start[1] + operation[1] >= size) {
                continue;
            } 
            start[0] = start[0] + operation[0];
            start[1] = start[1] + operation[1];
        }
        return start[0] * size + start[1];
    }

    



    public static void main(String[] args) {
        String[] cmds = {"RIGHT", "DOWN", "LEFT", "LEFT", "DOWN"};
        String[] cmds2 = {"RIGHT", "UP", "DOWN", "LEFT", "LEFT", "DOWN", "DOWN"};
        System.out.println(roverMove(4, cmds));
        System.out.println(roverMove(4, cmds2));
    }
}
