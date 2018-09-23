class randomRange{
    static Set<Integer> used;
    static int low;
    static int high;
    static Random rand;
    static int size;
    static int cnt;
    
   public randomRange(int l , int h) {
           used = new HashSet<>();
       rand = new Random();
       cnt = 0;
       low = l;
       high = h;
       size = h - l + 1;
   }
    
   public static int getRandom(){
       if (size == cnt){
           used = new HashSet<>();
           cnt = 0;
       }
       int num = 0;
       do{
           num = rand.nextInt((high - low) + 1) + low;
       } while (used.contains(num));
       cnt++;
       used.add(num);
       System.out.println(num);
       return num;
   }
}