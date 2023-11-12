import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // use a hash table (TreeMap)
        TreeMap<Integer, Integer> st = new TreeMap<Integer, Integer>();
        int[] res = new int[2];
        int k = target;
        //check input
        if (nums.length < 2) return null;


        // version 1: TimeOut, as I put key = index, value = array value

/*        for (int i = 0; i < nums.length; i++) {
        	st.put(i, nums[i]);
        }

        for (int i = 0; i < st.size(); i++) {
        	if (st.containsValue(k - nums[i])) {
        		res[0] = i + 1; //+1 to match output, index starting at 1
        		res[1] = -1;
        		// now look for the key given the value
        		Set<Integer> keys = st.keySet();
        		for(Integer key: keys){ 
        			// System.out.println(key); 
        			if (st.get(key) == (k - nums[i]))
        				res[1] = (int)key + 1; //+1 to match output, index starting at 1
        		} 
        		return res;
        	}
        }*/


        // version 2: put key = array value, value = index; assuming no identical array values (dangerous assumption)
        for (int i = 0; i < nums.length; i++) {
        	if (st.containsKey(k - nums[i])) {
        		int temp = (int)st.get(k - nums[i]) + 1; //+1 to match output, index starting at 1
        		if (temp < (i + 1)) {
        			res[0] = temp;
        			res[1] = i + 1;
        		}
        		else {
        			res[0] = i + 1;
        			res[1] = temp;
        		} 
        		
        		return res;
        	}
        	st.put(nums[i],i); // create hash map on the go to save time and space
        }

        return res;
    }

    // test main
    public static void main(String[] args) {
    	int[] a = {1,5,6,15};
    	int k = 16;
    	int[] res;
    	res = twoSum(a, k);
    	for (int i:res)
    		System.out.println(i);
    }
}
