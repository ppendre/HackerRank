/*    Problem description : https://www.hackerrank.com/challenges/picking-numbers
 *
 *    Time complexity: O(n * log(n))
 *    
 *    Environment: www.hackerrank.com - Java 8
 *    
 *     To use outside HackerRank please modify 
 *     BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));   line to
     BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
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

class Result {

    public static int pickingNumbers(List<Integer> a) {
        /* Solution:
         * Order the array.
         * Iterate on the array once
         * Checking the element is diffrent from the previous and
         *      the difference is <= 1, count number
         */                           

        int actualCount = 0;    
        int prevCount = 0;
        int actualNum;
        int maximum = 0;
        
        Collections.sort(a);
        
	actualNum = a.get(0);
        for(int i : a) {
            if(i != actualNum) {
                maximum = Math.max(maximum, actualCount + prevCount);
                // if difference is >1 the previous doesn't matter
                prevCount = i <= actualNum +1 ? actualCount : 0;
                actualCount = 1;
                actualNum = i;   
                }
            else {
                actualCount++;  
            }            
        }
        
	//Checking the max necessary when all of the element are same  
        return Math.max(maximum, actualCount + prevCount);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
