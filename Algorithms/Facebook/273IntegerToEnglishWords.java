class Solution {
    String[] lessThan20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", 
                                       "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", 
                                       "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", 
                                 "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = new String[]{"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0){
            return "Zero";
        }

        
        int level = 0;
        String words = "";
        while (num > 0){
            if (num % 1000 != 0){
                words = lessThanThousand(num % 1000)+thousands[level] +" "+ words;
            }
            level++;
            num /= 1000;
        }
        return words.trim();
    }
    
    private String lessThanThousand(int num){
       if (num == 0){
           return "";
       } else if (num < 20){
           return lessThan20[num] + " ";
       } else if (num < 100){
           return tens[num / 10] + " " + lessThanThousand(num % 10);
       } else {
           return lessThan20[num / 100] + " Hundred "+ lessThanThousand(num % 100);
       }
    }
    
}