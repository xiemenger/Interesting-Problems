import java.util.HashMap;
import java.util.Map;

public class HuffmanDecoder {
    private static String huffmanDecoder(String[] dicts, String input) {
        // sanity check
        if (input.isEmpty()) return null;
        
        Map<String, String> matches = new HashMap<>();
        for (String dict : dicts) {
            String[] s = dict.split(" ");
            if (s[0].equals("newline")) {
                matches.put(s[1], "\n");
            } else {
                matches.put(s[1], s[0]);
            }
        }

        StringBuilder res = new StringBuilder();
        StringBuilder code = new StringBuilder();
        int idx = 0;
        while (idx < input.length()) {
            code.append(input.charAt(idx));
            String toMatch = code.toString();
            if (matches.containsKey(toMatch)) {
                res.append(matches.get(toMatch));
                code.setLength(0);
            } 
            idx++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] dict = {"a 100100", "b 100101", "c 110001", "d 100000", "newline 1111111", "p 111110", "q 000001"};
        String input = "1111100000011001001111111100101110001100000";
        System.out.print(huffmanDecoder(dict, input));
    }
}
