import java.io.*;
import java.util.*;

class TimeStamp{
    public static void main(String[] args) {
		getTimeStamp("./a.txt");
	}
	
	private static void getTimeStamp(String filename) {
		System.out.println(filename);
		String fileWrite = "req_filename.txt";
		BufferedReader br = null;
		BufferedWriter bw = null;
		Map<String, Integer> freq = new HashMap<>();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileWrite)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while (line != null) {
			int l = line.indexOf("[");
            int r = line.indexOf("]");
            //System.out.println("l:"+l+"  r:"+r);
            String ts = line.substring(l + 1, r);
            ts = ts.substring(0, ts.indexOf(" "));
			if (freq.containsKey(ts) && freq.get(ts) == 1) {
				try {
					bw.write(ts);
					bw.write("\n");
				} catch (IOException e) {
                    e.printStackTrace();
				} 
			}
            freq.put(ts, freq.getOrDefault(ts, 0) + 1);
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
        
		try {
			bw.flush();
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}