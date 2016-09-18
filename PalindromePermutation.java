/**

Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

Hint:

Consider the palindromes of odd vs even length. What difference do you notice?
Count the frequency of each character.
If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?

*/

public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> chars = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!chars.add(s.charAt(i))) {
                chars.remove(s.charAt(i));
            }
        }
        
        return chars.size() == 0 || chars.size() == 1;
    }
}

public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] chars = new int[128];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        
        int odd = 0;
        for (int num : chars) {
            if (num % 2 == 1) {
                odd++;
            }
        }
        
        return odd < 2;
    }
}
