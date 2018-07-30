/**
给两个array [2,1,1,3,3,4,5,8,7], [7,1,3] 
按照第二个array的顺序来sort第一个array，如果没有出现，就按照大小来sort
[7,1,1,2,3,3,4,5,8]
*/
Class Solution{
    public void sort(int[] nums, int[] seqs){
        Map<Integer, Integer> sortInfo = new HashMap<>();
        for (int i = 0; i < seqs.length; i++){
            sortInfo.put(seqs[i], i);
        }

        Arrays.sort(nums, new Comparator<Integer>(){
            public int compare(Integer num1, Integer num2){
                if (sortInfo.containsKey(num1) && sortInfo.containskey(num2)){
                    return sortInfo.get(num1) - sortInfo.get(num2);
                }
                return num1 - num2;
            }
        });
    }
}
