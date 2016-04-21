/**

Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.

*/

public class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int[] res = new int[l1 + l2];
        int p1, p2, num, sum;
        
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                num = (c1[i] - '0') * (c2[j] - '0');
                p1 = i + j;
                p2 = i + j + 1;
                
                sum = num + res[p2];
                
                res[p1] += sum / 10;
                res[p2] = sum % 10;
            }
        } // end for
        
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            if (i == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(i);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

