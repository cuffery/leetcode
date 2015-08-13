import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MovingAverage {
    
    private static ArrayList<Double> inputs = new ArrayList<Double>();
    public static int windowSize;
    
    public static void main(String[] args) throws IOException {
        //File in = new File ("input.txt");
        Scanner sc = new Scanner (System.in);
        windowSize = sc.nextInt();
        System.out.println(windowSize);
        if (windowSize <= 0) throw new IOException("bad input");
        
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            if (!line.isEmpty()) {
                inputs.add(Double.parseDouble(line));
                movAvg();
            }
        }
        sc.close();
    }
    
    public static void movAvg() {
        double sum = 0.0;
        if (inputs.size() < windowSize) return;
        for (int i = inputs.size() - 1; i >= inputs.size() - windowSize; i--) {
            sum = sum + inputs.get(i);
        }
        System.out.println(String.format("%.3f", (sum / (windowSize * 1.0))));
        return;
    }
}
    
  