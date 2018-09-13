import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.glass.ui.Size;

public class WhoIsTheClosest {

    private static int[] closest(String s, int[] indexes) {
        int[] res = new int[indexes.length];
        if (s.isEmpty()){
            return res;
        }

        int[] dists = new int[s.length()];
        preProcess(s, dists);

        for (int i = 0; i < indexes.length; i++){
            res[i] = dists[indexes[i]];
        }
        return res;
    }

	
	private static void preProcess(String s, int[] dists){
        List<Integer>[] positions = new ArrayList[26];
        for (int i = 0; i < s.length(); i++){
            int cIdx = s.charAt(i) - 'a';
            if (positions[cIdx] == null){
                positions[cIdx] = new ArrayList<>();
            }
            positions[cIdx].add(i);

            // compute distances
            int size = positions[cIdx].size();
            if (size == 1){
                dists[i] = -1;
            } else if (size == 2){
                int lIdx = positions[cIdx].get(0);
                dists[lIdx] = i;
                dists[i] = lIdx;
            } else {
                int lIdx = positions[cIdx].get(size - 3);
                int mIdx = positions[cIdx].get(size - 2);
                int rIdx = i;
                dists[i] = mIdx;
                if (mIdx - lIdx > rIdx - mIdx){
                    dists[mIdx] = rIdx;
                }
            }
        }
        
    }

    // private static int[] closest(String s, int[] indexes) {
    //     int[] res = new int[indexes];
    //     Arrays.fill(res, -1);
    //     if (s.isEmpty()){
    //         return res;
    //     }

    //     int[] dists = new int[s.length()];
    //     preProcess(s, dists);

    //     for (int i = 0; i < indexes.length; i++){
    //         res[i] = dists[indexes[i]];
    //     }
    //     return res;
    // }

    // private static void preProcess(String s, int[] dists){
    //     List[] positions = new List[26];
    //     for (int i = 0; i < s.length(); i++){
    //         int cIdx = s.charAt(i) - 'a';
    //         if (positions[cIdx] == null){
    //             positions[cIdx] = new ArrayList<>();
    //         }
    //         positions[cIdx].add(i);

    //         // compute distances
    //         int size = positions[cIdx].size();
    //         if (size == 1){
    //             dists[i] = 0;
    //         } else if (size == 2){
    //             int lIdx = positions[cIdx].get(0);
    //             dists[lIdx] = i;
    //             dists[i] = lIdx;
    //         } else {
    //             int lIdx = positions[cIdx].get(size - 3);
    //             int mIdx = positions[cIdx].get(size - 2);
    //             int rIdx = i;
    //             dists[i] = mIdx;
    //             if (mIdx - lIdx > rIdx - mIdx){
    //                 dists[mIdx] = rIdx;
    //             }
    //         }
    //     }
    // }

    // private static int[] closest2(String s, int[] indexes) {
    //     // use two hashmap
    //     // first store index O(n) and process at the same time
    //     Map<Character, List<Integer>> charToList = new HashMap<>();
    //     int[] indexDict = new int[s.length()];
    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if (charToList.containsKey(c)) {
    //             charToList.get(c).list.add(i);
    //             // after adding, check if the size is larger or equal to 3
    //             int tempIdx = list.size() - 1;
    //             if (tempIdx >= 2) {
    //                 int beforeDiff = list.get(tempIdx - 1) - list.get(tempIdx - 2);
    //                 int afterDiff = list.get(tempIdx) - list.get(tempIdx - 1);
    //                 // update the index map
    //                 if (afterDiff < beforeDiff) {
    //                     indexDict[list.get(tempIdx - 1)] = tempIdx;
    //                 }
    //             } else if (tempIdx == 1) {
    //                 // update the first
    //                 indexDict[list.get(tempIdx - 1)] = tempIdx;
    //             }
    //             // add the before by default
    //             indexDict[i] = tempIdx - 1;
    //         } else {
    //             List<Integer> list = new ArrayList<>();
    //             list.add(i);
    //             charToList.put(c, list);
    //             // since it is the very first, index start with itself
    //             indexDict[i] = 0;
    //         }
    //     }

    //     // process the indexes
    //     int[] res = new int[indexes.length];
    //     for (int i = 0; i < indexes.length; i++) {
    //         int idx = indexes[i];
    //         int mapIndex = charToList.get(s.charAt(idx)).get(indexDict[idx]);
    //         res[i] = mapIndex == idx ? -1 : mapIndex;
    //     }

    //     return res;


    // }

    // private static void printArray(int[] array) {
    //     for (int i : array) {
    //         System.out.println(i);
    //     }
    // }

    // public static void main(String[] args) {
    //     // testcase 1
    //     String test1 = "babab";
    //     int[] index1 = {2};
    //     printArray(closest(test1, index1));
    //     // 0

    //     // testcase 2
    //     String test2 = "hackerrank";
    //     int[] index2 = {4, 1, 6, 8};
    //     printArray(closest(test2, index2));
    //     // -1 7 5 -1

    // }
}
