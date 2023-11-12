import java.io.*;
import java.util.*;

public class Deadlocks {
    
    private static ArrayList<String> inputs = new ArrayList<String>();
    public static int windowSize;
    public static double perc;
    
    public static void main(String[] args) throws IOException {
        File in = new File ("inputDead.txt");
        Scanner sc = new Scanner (in);
        //Scanner sc = new Scanner (System.in);
        
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            inputs.add(line);
        }
        sc.close();
        run();
    }
    
    public static void run() {   
        if (inputs.size() <= 0) return;
        LinkedHashMap<String, String[]> map = new LinkedHashMap<String, String[]>();
        // get inputs
        for (String i:inputs) {
            String[] temp = i.split(" ");
            if(temp.length > 1){
                String[] paths = temp[1].split(",");
                //ArrayList<String> p = new ArrayList<String>();
                //p.addAll(paths);
                map.put(temp[0], paths);
            }
        }
        
        // now iterate thru the entire hashmap to compare each pair
        int indexOne = 0;
        for (Entry<String, String[]> entry : map.entrySet()) {
            String[] one = entry.getValue();
            
            for (Entry<String, String[]> otherEntry : map.entrySet()) {
                if (!entry.equals(otherEntry)) {
                    for (int i = 0; i < otherEntry.getValue().length; i++)
                        if one[]
                }
            }
            
        }
        
        return;
    }
    
}

