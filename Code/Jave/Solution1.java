public class Solution { 
    public int[] twoSum(int[] numbers, int target) { 
         Array.sort(numbers);
         for (int i = 0; numbers[i] <= target; i++) {
             for (int j = 0; numbers[j] <= target; j++) {
                 if ((numbers[i] + numbers[j]) == target) {
                     System.out.println("index1=" + i +", index2=" + j);
                     int[] res = {numbers[i],numbers[j]};
                     return res;
             }
         }
    }
    
    public static void main() {
        int[] n = {2, 7, 11, 15};
        
}