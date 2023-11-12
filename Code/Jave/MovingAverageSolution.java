import java.io.*;
import java.util.ArrayList;

public class MovingAverageSolution {
    
    private ArrayList<String> inputs = new ArrayList<String>();
    public int windowSize;
    
    public MovingAverageSolution() {
        
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        MovingAverageSolution solution = new MovingAverageSolution();
        try {
            InputStream inputStream = new FileInputStream("input.txt");
            Reader reader = new InputStreamReader(inputStream);
            br = new BufferedReader(reader);

            solution.windowSize = Integer.parseInt(br.readLine());
            String input = br.readLine();
            while(input != null){
                solution.inputs.add(input);
                solution.movingAvg(solution.inputs);
                input = br.readLine();
            }
            
        } finally {
            if (br != null)
                br.close();
        }
    }
    
    public void movingAvg(ArrayList<String> inputs) {
        //illegal/incomplete input 
        if(windowSize <= 0 || inputs.size() < windowSize){
            return;
        }
        
        double sum = 0;
        for(int i=inputs.size() - 1; i >= inputs.size() - windowSize; i--){
            sum = sum + Double.parseDouble(inputs.get(i));
        }
        double average = sum / (windowSize * 1.0);
        System.out.println(String.format("%.3f", average));
    }
    
}