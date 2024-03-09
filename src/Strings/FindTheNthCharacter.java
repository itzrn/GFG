package src.Strings;

/**
 * Given a binary string s. Perform r iterations on string s, where in each iteration 0 becomes 01 and 1 becomes 10.
 * Find the nth character (considering 0 based indexing) of the string after performing these r iterations (see examples for better understanding).
 *
 * Example 1:
 *
 * Input:
 * s = "1100"
 * r = 2
 * n = 3
 * Output:
 * 1
 * Explanation:
 * After 1st iteration s becomes "10100101".
 * After 2nd iteration s becomes "1001100101100110".
 * Now, we can clearly see that the character at 3rd index is 1, and so the output.
 * Example 2:
 *
 * Input:
 * s = "1010"
 * r = 1
 * n = 2
 * Output:
 * 0
 * Explanation :
 * After 1st iteration s becomes "10011001".
 * Now, we can clearly see that the character at 2nd index is 0, and so the output.
 * Your task:
 * You don't need to read input or print anything. Your task is to complete the function nthCharacter()
 * which takes the string s and integers r and n as input parameters and returns the n-th character of the string after performing r operations on s.
 *
 * Expected Time Complexity: O(r*|s|)
 * Expected Auxilary Space: O(|s|)
 *
 * Constraints:
 * 1 ≤ |s| ≤ 103
 * 1 ≤ r ≤ 20
 * 0 ≤ n < |s|
 */

public class FindTheNthCharacter {
    public char nthCharacter(String s, int r, int n){
        int len = s.length();
        int a = (int)Math.pow(2, r); // this is calculating the length of substring in the final string developed form each character
        int start = 0; // this is the staring index of the range of first string developed from first character of the string
        int end = a-1; // this is the ending index of the range of first string developed form first character of the string

        // here the time complexity is O(n)
        for(int i=0; i<len; i++){// traveling through every character of the string
            if(n>=start && n<=end){ // as we identify that n belongs to the range of this particular character in the final string
                n-=start; // updating the index of the range and making that range to index at 0, so we can easily take the reference
                return recursion(s.charAt(i), r, n);
            }
            start += a;
            end += a;
        }

        return '0';
    }

    public char recursion(char ch, int r, int n){ // doing in a path recursively, here the time complexity is r-1
        if(r == 1){
            if(ch == '1'){
                if(n == 0){
                    return '1';
                }else{
                    return '0';
                }
            }else{
                if(n == 0){
                    return '0';
                }else{
                    return '1';
                }
            }
        }

        int a = (int) Math.pow(2, r-1);
        if(n>=0 && n<a){
            if(ch == '1'){
                return recursion('1', r-1, n);
            }else{
                return recursion('0', r-1, n);
            }
        }else{
            if(ch == '1'){
                return recursion('0', r-1, n-a);
            }else{
                return recursion('1', r-1, n-a);
            }
        }
    }
}
