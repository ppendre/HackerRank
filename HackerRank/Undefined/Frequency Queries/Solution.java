/*	Problem description :  https://www.hackerrank.com/challenges/frequency-queries/
 *
 * 	The original storing process was modified, because of fastest code
 *	
 *	Time complexity: 					O(log(n))
 *						queries: 		O(log(n))
 *						add & delete : 	O(log(n))
 *	
 *	Environment: www.hackerrank.com - Java 8
 *	
 * 	To use outside HackerRank please modify 
 * 	BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));   line to
 	BufferedWriter(new OutputStreamWriter(System.out));
 */	
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
	static List<Integer> freqQuery(List<int[]> queries) {
    	List<Integer> result = new ArrayList<>();
    	/* numMap for store num and its frequency;
    	 * fregMap for store frequency and its frequency
    	 */
    	
    	Map<Integer, Integer> numMap = new HashMap<>();
    	Map<Integer, Integer> freqMap = new HashMap<>();
    	for(int[] query : queries) {
    		int key = query[0];
    		int elem = query[1];
    		int freq;
    		switch(key) {
    			case 1:
    				freq = numMap.getOrDefault(elem, 0);
    				numMap.put(elem, freq + 1);
    				freqMap.put(freq + 1, freqMap.getOrDefault(freq + 1 , 0) + 1);
    				freqMap.put(freq , Math.max(freqMap.getOrDefault(freq , 0) - 1, 0));
    			break;
    			case 2:
    				freq = numMap.getOrDefault(elem, 0);
    				numMap.put(elem, Math.max(freq - 1, 0));
    				freqMap.put(freq - 1, freqMap.getOrDefault(freq -1, 0) + 1);
    				freqMap.put(freq , Math.max(freqMap.getOrDefault(freq , 0) - 1, 0));					
				break;
    			case 3:
    				result.add(freqMap.getOrDefault(elem, 0) != 0 ? 1 : 0);
    			break;	
    		}
    	}
    	
    	return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
          int q = Integer.parseInt(bufferedReader.readLine().trim());
          List<int[]> queries = new ArrayList<>(q);
          Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
          for (int i = 0; i < q; i++) {
            int[] query = new int[2];
            Matcher m = p.matcher(bufferedReader.readLine());
            if (m.matches()) {
              query[0] = Integer.parseInt(m.group(1));
              query[1] = Integer.parseInt(m.group(2));
              queries.add(query);
            }
          }
          List<Integer> ans = freqQuery(queries);
          try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH"))) {
            bufferedWriter.write(
                    ans.stream()
                            .map(Object::toString)
                            .collect(joining("\n"))
                            + "\n");
          }
        }
      }
}    