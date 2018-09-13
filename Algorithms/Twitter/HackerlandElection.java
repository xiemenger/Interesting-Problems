import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class HackerlandElection {
    private static String hackerlandElection(String[] votes) {
        // create a treemap to store the value in order
        Map<String, Integer> cnts = new HashMap<>();
        int maxCnt = 0;
        String winner = "";
      
        for (String vote : votes) {
            int cnt = cnts.getOrDefault(vote, 0) + 1;
            cnts.put(vote, cnt);
            if (cnt >= maxCnt){
                if (cnt > maxCnt || vote.compareTo(winner) < 0){
                    winner = vote;
                }
                maxCnt = cnt;
            }
        }
        return winner;
    }

    public static void main(String[] args) {
        String[] votes = { "victor", "veronica", "ryan", "dave", "maria", "farah", "farah", "ryan", "veronica" };
        String[] votes2 = {"Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary"};
        System.out.println(hackerlandElection(votes2));
    }
}
