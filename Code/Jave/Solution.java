import java.util.Arrays;

public class Solution { 
    public int[] twoSum(int[] numbers, int target) { 
         Arrays.sort(numbers);
         int[] res = new int[2];
         for (int i = 0; (numbers[i] <= target) && i < numbers.length; i++) {
             for (int j = i+1; j < numbers.length; j++) {
                 if ((numbers[i] + numbers[j]) == target) {
                     
                     res[0] = i+1;
                     res[1] = j+1;
                     System.out.println("index1=" + res[0] +", index2=" + res[1]);
                     return res;
                 }
             }
         }
         return res;
    }
    
    public static void main(String[] args) {
        int[] n = {5,75,25};
        Solution sol = new Solution();
        int[] res = sol.twoSum(n, 100);
        return;
    }
}