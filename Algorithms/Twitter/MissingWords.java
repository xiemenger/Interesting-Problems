import java.util.ArrayList;
import java.util.List;

public class MissingWords {
    private static List<String> missingWords(String s, String t) {
        // store the two lists
        String[] sWords = t.split(" ");
        String[] tWords = t.split(" ");
        List<String> res = new ArrayList<>();

        int spos = 0;
        int tpos = 0;

        while (tpos < tWords.length) {
            String tWord = tWords[tpos];
            while (spos < sWords.length) {
                String sWord = sWords[spos];
                if (sWord.equals(tWord)) {
                    // if the two are the same, both add 1
                    spos++;
                    tpos++;
                    break;
                } else {
                    res.add(atemp);
                    spos++;
                }
            }
        }

        // to check if there is still missing
        while (spos < sWords.length) {
            res.add(sWords[spos]);
            spos++;
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "I am using HackerRank to improve programming";
        String str2 = "am HackerRank to improve";
        for (String str : missingWords(str1, str2)) {
            System.out.println(str);
        }
    }
}
