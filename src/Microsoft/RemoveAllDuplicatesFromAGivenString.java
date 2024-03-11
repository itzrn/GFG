package src.Microsoft;

/**
 * Given a string str which may contains lowercase and uppercase chracters.
 * The task is to remove all duplicate characters from the string and find the resultant string.
 * The order of remaining characters in the output should be same as in the original string.
 *
 * Example 1:
 *
 * Input:
 * str = "geEksforGEeks"
 * Output:
 * "geEksforG"
 * Explanation:
 * After removing duplicate characters such as E, e, k, s, we have string as "geEksforG".
 * Example 2:
 *
 * Input:
 * str = "HaPpyNewYear"
 * Output:
 * "HaPpyNewYr"
 * Explanation:
 * After removing duplicate characters such as e, a, we have string as "HaPpyNewYr".
 * Your Task:
 * Complete the function removeDuplicates() which takes a string str, as input parameters and returns a string denoting the answer.
 * You don't have to print answer or take inputs.
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(N)
 *
 * Constraints:
 * 1 ≤ N ≤ 105
 * String contains uppercase and lowercase english letters.
 */

import java.util.HashSet;
import java.util.Set;

public class RemoveAllDuplicatesFromAGivenString {
    String removeDuplicates(String str) {
        String ans = "";
        Set<Character> set = new HashSet<>();
        for(char i:str.toCharArray()){
            if(set.add(i)){
                ans = ans+i;
            }
        }

        return ans;
    }
}
