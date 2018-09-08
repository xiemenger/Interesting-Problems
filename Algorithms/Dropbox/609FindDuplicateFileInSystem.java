/**
  Time: O(n)
  Space: O(n)
*/

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> contents = new HashMap<>();
        for (String path : paths){
            String[] files = path.split(" ");
            String dir = files[0];
            for (int i = 1; i < files.length; i++){
                int idx = files[i].indexOf("(");
                String filepath = dir + "/" + files[i].substring(0, idx);
                String content = files[i].substring(idx + 1, files[i].length() - 1);
                if (!contents.containsKey(content)){
                    contents.put(content, new ArrayList<>());
                }
                contents.get(content).add(filepath);
            }
        }
        
        for (List<String> l : contents.values()){
            if (l.size() > 1){
                res.add(l);
            }
        }
        return res;
    }
}