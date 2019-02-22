/*    Problem description : https://www.hackerrank.com/challenges/balanced-brackets
 *
 *    Time complexity: O(n)
 *    
 *    Environment: www.hackerrank.com - Java 8
 *    
 *     To use outside HackerRank enviroment please modify 
 *     BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));   line to
 *     BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
 */    


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        
        String openBrackets = "{([";
        String closeBrackets = "})]";
        
        char currentChar;
        int pos = 0;
        
        while(pos < s.length()) {
            currentChar = s.charAt(pos);
            		// Case opening bracket: push it to the stack and check next char
            if(openBrackets.contains(String.valueOf(currentChar))) {
                stack.push(currentChar);
                pos++;
            }
            	// Case closing bracket: 
            else {
                	// There isn't pair for it in the stack --> BAD
                if(stack.size() == 0)
                    break;
                
                	// Check last open bracket pairs to the current?
                int bracketIndex = openBrackets.indexOf(stack.pop());
                if(closeBrackets.charAt(bracketIndex) != currentChar)
                    break;                    

                pos++;
            }                    
        }    

        	// Return YES if all the characters of the string was paired
        return pos == s.length() && stack.size() == 0 ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
