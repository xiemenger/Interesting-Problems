import java.io.*;
import java.util.*;

import sun.net.www.protocol.http.HttpURLConnection;

class solution{
    private static int getTopicCount(String topic){
        URLConnection wkConn;
        String targetUrl = "https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=pizza";
        try {
            URL wiki = new URL(targetUrl);
            wkConn = wiki.openConnection();
            BufferedReader br = new BufferedReader(
                                    new InputStreamReader(
                                            wkConn.getInputStream()));
            String line;
            int cnt = 0;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                System.out.println("~~~~~~~");
                    content.append(line);
            }
            
            String cont = content.toString();
            System.out.println(cont);
            int i = cont.indexOf("text");
            for (; i < cont.length(); i++) {
                    if (cont.startsWith(topic, i)) {
                        //System.out.println(i+"   "+cont.substring(i - 4, i + topic.length() + 4));
                        cnt++;
                    }
            }
            
            br.close();
            System.out.println(cnt);
            return cnt;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }     
    }
}