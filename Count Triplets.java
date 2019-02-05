//	Problem description :  https://www.hackerrank.com/challenges/count-triplets-1

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

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long,Long> map2 = new HashMap<Long,Long>();        
        HashMap<Long,Long> map3 = new HashMap<Long,Long>();
        /* map2 : how many triplets wait for a specific number in the middle
         * map3 : how many triplets wait for a specific number in the position 3
         */
        
        long result = 0;
       
        /* time coplexity : O(n*log(n))
         * if next number in the array is the 3. element of triplets DONE
         * if next number in the array is the 2. element of triplets update map3 to wait for the 3. element
         * Finaly this triplet waiting for 2. element (update map2 waiting for element * r)  
         */
        
        for(long tag : arr) {
            if(map3.containsKey(tag)) result += map3.get(tag);
        	if(map2.containsKey(tag)) map3.put(tag * r, map3.getOrDefault(tag * r, 0L) + map2.get(tag));
            map2.put(tag * r , map2.getOrDefault(tag * r, 0L) + 1);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());
        
        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


/*

100 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1

*/