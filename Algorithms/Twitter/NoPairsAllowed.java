import java.util.List;

public class NoPairsAllowed {
    
    private static int[] minimalOperations(String[] strs) {
		int[] res = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			res[i] = compute(strs[i]);
		}
		return res;
	}
	
	private static int compute(String s) {
		if (s.isEmpty()) {
			return 0;
		}
		int operation = 0;
		int cnt = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				cnt++;
			} else {
				operation += cnt / 2;
				cnt = 1;
			}
		}
		operation += cnt / 2;
		return operation;
	}

    // -------------------------------------------------------
    // Old
    private static int[] minimalOperations2(String[] input) {
        int[] res = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            int op = 0;
            // get the first
            char c = input[i].charAt(0);
            int count = 1;

            // loop from the second
            for (int j = 1; j < input[i].length(); j++) {
                if (input[i].charAt(j) == c) {
                    count++;
                } else {
                    // calculate the operation
                    op += count / 2;
                    count = 1;
                }
                c = input[i].charAt(j);
            }

            if (count > 1) {
                op += count / 2;
            }
            res[i] = op;
        }
        return res;
    }

    private static void printList(int[] list) {
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        // testcase1
        String[] input1 = {"ab", "aab", "abb", "abab", "abaaaba"};
        printList(minimalOperations(input1));
        // 0 1 1 0 1

        // testcase2
        String[] input2 = {"add", "boook", "break"};
        printList(minimalOperations(input2));
        // 1 1 0

    }
}
