package src.Walmart;

/**
 * Given a string s of length n, find the longest repeating non-overlapping substring in it.
 * In other words find 2 identical substrings of maximum length which do not overlap.
 * Return the longest non-overlapping substring. Return "-1" if no such string exists.
 *
 * Note: Multiple Answers are possible but you have to return the substring whose first occurrence is earlier.
 *
 * For Example: "abhihiab", here both "ab" and "hi" are possible answers. But you will have to return "ab"
 * because it's first occurrence appears before the first occurrence of "hi".
 *
 * Example 1:
 *
 * Input:
 * n = 9
 * s = "acdcdacdc"
 * Output:
 * "acd"
 * Explanation:
 * The string "acd" is the longest Substring of s which is repeating but not overlapping.
 * Example 2:
 *
 * Input:
 * n = 7
 * s = "heheheh"
 * Output:
 * "heh"
 * Explanation:
 * The string "heh" is the longest Substring of s which is repeating but not overlapping.
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function longestSubstring()
 * which takes a Integer n and a string s as input and returns the answer.
 *
 * Expected Time Complexity: O(n2)
 * Expected Auxiliary Space: O(n2)
 *
 * Constraints:
 * 1 <= n <= 103
 */

public class LongestRepeatingAndNonOverlappingSubstring {
    static String longestSubstring(String s, int n) {
        char[] str = s.toCharArray();
        int[][] dp = new int[n+1][n+1]; // using 2D dp
        int max=0;
        int index=0;
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){

                if(j-i > dp[i-1][j-1] && str[i-1]==str[j-1]){ // this checks 2 conditions 1->that the string are not  overlapping 2->To have two distinct repeating string
                    dp[i][j]=1+dp[i-1][j-1];
                    if(dp[i][j]>max){
                        max=dp[i][j];
                        index=Math.max(i,index);
                    }
                } else{ //this implies that at this moment there is no previous repeating character
                    dp[i][j]=0;
                }

            }
        }


        // the whole bellow procedure can be done in one line but i used the iterative method
        String res="";
        if(max>0){
            for(int i= index-max+1;i<=index;i++){
                res+=str[i-1];
            }
        }
        if(res==""){
            res="-1";
        }

        return res;
    }
}
