class Solution {
    public String validIPAddress(String IP) {
        if (isIPv4(IP)){return "IPv4"; }
        if (isIPv6(IP)){return "IPv6"; }
        return "Neither";
    }
    
    private boolean isIPv6(String IP){
        if (IP.length() < 15){return false; }
        if (IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':'){
            return false;
        }
        String[] tokens = IP.split(":");
        if (tokens.length != 8){return false; }
        for (String token : tokens){
            if (!isValidIPv6Token(token)){
                return false;
            }
        }
        return true;
    }
    
    private boolean isValidIPv6Token(String token){
        if (token.isEmpty()){return false; }
        int len = token.length();
        if (len > 4 ){ return false; }
        char[] chars = token.toCharArray();
        for (char c : chars){
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')){
                continue;
            }
            return false;
        }
        return true;
    }
    
    
    
    private boolean isIPv4(String IP){
        if (IP.length() < 7 || IP.length() > 15){return false; }
        if (IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.'){
            return false;
        }
        
        String[] tokens = IP.split("\\.");
        if (tokens.length != 4){return false; }
        for (String token : tokens){
            if (!isValidIPv4Token(token)){
                return false;
            }
        }
        return true;
    }
    
    private boolean isValidIPv4Token(String token){
        if (token.isEmpty()){return false; }
        int len = token.length();
        if (len > 3 || (token.charAt(0) == '0' && len > 1)){
            return false;
        }
        try {
            int num = Integer.parseInt(token);
            if (num < 0 || num > 255){ return false; }
            if (num == 0 && token.charAt(0) != '0'){return false; }
        } catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }
}