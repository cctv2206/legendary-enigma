/**

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.

*/

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        int index = 1;
        index <<= 30;
        while (index > 0) {
            if ((m & index) > 0 && (n & index) > 0) {
                result |= index;
            } else if ((m & index) > 0 || (n & index) > 0) {
                return result;
            }
            index >>= 1;
        }
        return result;
    }
}
