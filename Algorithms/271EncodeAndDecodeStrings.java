public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs){
            sb.append(s.length()+"/");
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int idx = 0;
        while (i < s.length()){
            idx = s.indexOf("/", i);
            int num = Integer.valueOf(s.substring(i, idx));
            i = idx+1+num;
            res.add(s.substring(idx + 1, i));
        }
        return res;
    }
}