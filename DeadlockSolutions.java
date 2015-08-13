package bridgewater;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class DeadLockSolution {
	
	private List<String> inputs = new ArrayList<String>();
	
	public DeadLockSolution(){
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = null;
		DeadLockSolution solution = new DeadLockSolution();
		try {
			InputStream inputStream = new FileInputStream("input.txt");
			Reader reader = new InputStreamReader(inputStream);
			br = new BufferedReader(reader);
			
//			br = new BufferedReader(new InputStreamReader(System.in));
			
			String input = br.readLine();
			while(input != null){
				solution.inputs.add(input);
				input = br.readLine();
			}
			solution.process(solution.inputs);
			
		} finally {
			if (br != null)
				br.close();
		}
	}

	public void process(List<String> inputs) {
		LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();
		
		for (String string : inputs) {
			String[] splits = string.split(" ");
			if(splits.length > 1){
				String[] tmp = splits[1].split(",");
				ArrayList<String> locks = new ArrayList<String>();
				locks.addAll(Arrays.asList(tmp));
				map.put(splits[0], locks);
			}
		}
//		print(map);
		
		LinkedHashSet<ArrayList<String>> ret = new LinkedHashSet<ArrayList<String>>();
		int entryIndex = 0;
		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
			ArrayList<String> value = entry.getValue();
			int i = 0;
			do{
				int otherEntryIndex = 0;
				for(Entry<String, ArrayList<String>> otherEntry : map.entrySet()){
					if(otherEntryIndex>entryIndex && !entry.equals(otherEntry)){
						ArrayList<String> otherValue = otherEntry.getValue();
						if(otherValue.contains(value.get(i))){
							int FirstHitIndex = otherValue.indexOf(value.get(i));
							if((i+1)%value.size() == 0){		// Special case, when looping around!
								if(FirstHitIndex+1<otherValue.size() && otherValue.get(FirstHitIndex+1).equals(value.get((i+1)%value.size()))){
									ArrayList<String> conflicts = new ArrayList<String>();
									conflicts.add(entry.getKey());
									conflicts.add(otherEntry.getKey());
									ret.add(conflicts);
								}
							}else{
								if(FirstHitIndex-1>=0 && otherValue.get(FirstHitIndex-1).equals(value.get((i+1)%value.size()))){
									ArrayList<String> conflicts = new ArrayList<String>();
									conflicts.add(entry.getKey());
									conflicts.add(otherEntry.getKey());
									ret.add(conflicts);
								}
							}
						}
					}
					otherEntryIndex++;
				}
				i++;
				i %= value.size();
			}while(i != 0);
			entryIndex++;
		}
		
//		System.out.println(ret);
		for (ArrayList<String> al : ret) {
			System.out.println(al.get(0)+","+al.get(1));
		}
	}
	
	public void print(Map<String, ArrayList<String>> map){
		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
			 String key = entry.getKey();
			 ArrayList<String> value = entry.getValue();
		    System.out.println(key + "->" + value);
		}
		
		
//		Iterator it = map.entrySet().iterator();
//	    while (it.hasNext()) {
//	        Map.Entry pairs = (Map.Entry)it.next();
//	        System.out.println(pairs.getKey() + " = " + pairs.getValue());
//	    }
	}

}