package src;

/*
Given a string s which contains only lower alphabetic characters,
check if it is possible to remove at most one character from this string in such a way that
frequency of each distinct character becomes same in the string. Return true if it is possible to do else return false.

Note: The driver code print 1 if the value returned is true, otherwise 0.

Example 1:

Input:
s = "xyyz"
Output:
1
Explanation:
Removing one 'y' will make frequency of each character to be 1.
Example 2:

Input:
s = "xxxxyyzz"
Output:
0
Explanation:
Frequency can not be made same by removing at most one character.
Your Task:
You dont need to read input or print anything. Complete the function sameFreq() which takes a string as
input parameter and returns a boolean value denoting if same frequency is possible or not.

Expected Time Complexity: O(|s|)
Expected Auxiliary Space: O(1)

Constraints:
1 <= |s| <= 105
 */

public class CheckIfFrequencyCanBeEqual {
    boolean sameFreq(String s) {
        int[] freq = new int[26];
        char[] str = s.toCharArray();
        for(char i:str){
            freq[i-'a']++;
        }
        // as we have given in the question atmost 1 operation needed, -> 0 or 1 operation is need to perform
        if(isSame(freq)){ // this is to check in 0 operation can we make frequency equal or not
            return true;
        }

        for(int i = 0; i<26; i++){
            if(freq[i] != 0){ // the character with non-zero frequency
                freq[i]--; // decreasing frequency by 1(which implies we performed one operation)
                if(isSame(freq)){ // and checking do we get all the frequency same or not
                    return true; // if same then return true
                }

                freq[i]++; // increasing the frequency of that particular character so we can perform that one operation on other character
            }
        }

        return false; // return false if it's not possible
    }

    public boolean isSame(int[] arr){ // checking if all the non-zero frequency of every character is same or not
        int a = -1;
        for(int i:arr){
            if(i!=0){
                if(a == -1){
                    a = i;
                }

                if(a != i){
                    return false;
                }
            }
        }

        return true;
    }
}
