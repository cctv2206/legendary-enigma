/**

Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

*/

public class Solution {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        
        return (int) (n%3 == 0 ? Math.pow(3, n / 3) : (n%3 == 1 ? Math.pow(3, n / 3 - 1) * 4 : Math.pow(3, n / 3) * 2));
    }
}
