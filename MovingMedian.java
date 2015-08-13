import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class MovingMedian {
    
    private static ArrayList<Double> inputs = new ArrayList<Double>();
    public static int windowSize;
    public static double perc;
    
    public static void main(String[] args) throws IOException {
        //File in = new File ("inputMed.txt");
        //Scanner sc = new Scanner (in);
        Scanner sc = new Scanner (System.in);
        windowSize = sc.nextInt();
        perc = sc.nextDouble();
        //System.out.println(windowSize);
        //System.out.println(perc);
        if (windowSize <= 0) throw new IOException("bad input");
        
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            if (!line.isEmpty()) {
                inputs.add(Double.parseDouble(line));
                movMed();
            }
        }
        sc.close();
    }
    
    public static void movMed() {
        // need at least (windowSize+1) data points
        if (inputs.size() <= windowSize) return;
        //find median first
        double comp = inputs.get(inputs.size() - 1);
        
        double[] med = new double[windowSize];
        for (int i = inputs.size() - 2; i >= inputs.size() - windowSize - 1; i--) {
            med[inputs.size() - 2 - i] = inputs.get(i);
        }
        Arrays.sort(med);
        double median = 0.0;
        if (windowSize % 2 == 0) median = (med[windowSize / 2 - 1] + med[windowSize / 2]) * 1.0 / 2;
        else median = med[windowSize / 2];
        
        if ((Math.abs(comp - median)/median) > perc) System.out.println(String.format("%.3f", comp));
        return;
    }
}
    
  