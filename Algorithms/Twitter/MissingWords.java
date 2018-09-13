import java.util.ArrayList;
import java.util.List;

public class MissingWords {
    private static List<String> missingWords(String a, String b) {
        // store the two lists
        String[] alist = a.split(" ");
        String[] blist = b.split(" ");
        List<String> res = new ArrayList<>();

        int apos = 0;
        int bpos = 0;

        while (bpos < blist.length) {
            String btemp = blist[bpos];
            while (apos < alist.length) {
                String atemp = alist[apos];
                if (atemp.equals(btemp)) {
                    // if the two are the same, both add 1
                    apos++;
                    bpos++;
                    break;
                } else {
                    res.add(atemp);
                    apos++;
                }
            }
        }

        // to check if there is still missing
        while (apos < alist.length) {
            res.add(alist[apos]);
            apos++;
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
