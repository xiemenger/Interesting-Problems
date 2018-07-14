class Solution {
     public String addBoldTag(String s, String[] dict) {
         int n = s.length();
         boolean[] bold = new boolean[n];
         
         for (int i = 0; i < n; i++){
             for (String w : dict){
                 if (s.startsWith(w, i)){
                    fillTrue(bold, i, i + w.length() - 1); 
                 }
             }
         }
         
         int l = 0;
         int r = 0;
         StringBuilder sb = new StringBuilder();
         while (r < n){
             while (r < n && !bold[r]){
                 r++;
             }
             sb.append(s.substring(l, r));
             if (r == n){
                 break;
             }
            
             sb.append("<b>");
             l = r;
             while (r < n && bold[r]){
                 r++;
             }
             sb.append(s.substring(l, r));
             sb.append("</b>");
             l = r;
         }
         return sb.toString();
     }
    
    private void fillTrue(boolean[] bold, int i, int j){
        while (i <= j){
            bold[i++] = true;
        }
    }
    
    
    public String addBoldTag2(String s, String[] dict) {
        if (dict == null || dict.length == 0){return s; }
        if (s.isEmpty()){ return ""; }
        
        List<Interval> list = new ArrayList<>();
        
        for (String str : dict){
            int idx = -1;
            while (idx < s.length()){
                idx = s.indexOf(str, idx + 1);
                if (idx < 0){
                    break;
                }
                list.add(new Interval(idx, idx + str.length()));
            }
        }
        
        if (list.size() == 0){
            return s;
        }
        
        Collections.sort(list, (a, b) -> (a.start != b.start ? a.start - b.start : a.end - b.end));
        List<Interval> tmp = new ArrayList<>();
        tmp.add(list.get(0));
        
        for (int i = 1; i < list.size(); i++){
            Interval cur = list.get(i);
            if (cur.start <= tmp.get(tmp.size() - 1).end){
                tmp.get(tmp.size() - 1).end = Math.max(cur.end, tmp.get(tmp.size() - 1).end);
            } else {
                tmp.add(cur);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int si = 0;
        for (Interval t : tmp){
            sb.append(s.substring(si, t.start));
            sb.append("<b>");
            sb.append(s.substring(t.start, t.end));
            sb.append("</b>");
            si = t.end;
        }
        if (si < s.length()){
            sb.append(s.substring(si, s.length()));
        }
        return sb.toString();
    }
    
    class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}