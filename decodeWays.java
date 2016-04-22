/**

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

*/

public class Solution {
    public int numDecodings(String s) {
        char[] charArray = s.toCharArray();
        int length = s.length();
        if (length == 0 || charArray[0] == '0') {
            return 0;
        }
        
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= length; i++) {
            if (charArray[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            if (charArray[i - 2] == '1' || (charArray[i - 2] == '2' && charArray[i - 1] - '0' < 7)) { // 10 to 26
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }
}
