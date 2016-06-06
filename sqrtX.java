/**

Implement int sqrt(int x).

Compute and return the square root of x.

*/

public class Solution {
    public int mySqrt(int x) {
        if (x < 4) {
            return x == 0 ? 0 : 1;
        }
        int res = 2 * mySqrt(x / 4);
        if ((res + 1) * (res + 1) <= x && (res + 1) * (res + 1) >= 0) return res + 1;
        return res;
    }
}
