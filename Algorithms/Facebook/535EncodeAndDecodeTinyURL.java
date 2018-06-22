public class Codec {

    // Encodes a URL to a shortened URL.
    Map<String, String> shortToLong = new HashMap<>();
    Map<String, String> longToShort = new HashMap<>();
    static String Host = "http://tinyurl.com/";
    
    public String encode(String longUrl) {
        
        if (longToShort.containsKey(longUrl)){
            return Host + longToShort.get(longUrl);
        }
        java.util.Random rand = new java.util.Random();
        String src = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = "";
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++){
                sb.append(src.charAt(rand.nextInt(src.length())));
            }
            key = sb.toString();
        } while (shortToLong.containsKey(key));
        
        shortToLong.put(key, longUrl);
        longToShort.put(longUrl, key);
        return Host+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl.replace(Host, ""));
    }
}