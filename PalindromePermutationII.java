/**
Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].

Hint:

If a palindromic permutation exists, we just need to generate the first half of the string.
To generate all distinct permutations of a (half of) string, use a similar approach from: Permutations II or Next Permutation.
*/

public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<String>();
        Set<Character> charSet = new HashSet<Character>();
        String chars = "";
        for (int i = 0; i < s.length(); i++) {
            if (!charSet.add(s.charAt(i))) {
                chars += s.charAt(i);
                charSet.remove(s.charAt(i));
            }
        }
        if (charSet.size() < 2) {
            List<String> firstHalf = new ArrayList<String>();
            permutations(chars.toCharArray(), 0, firstHalf);
            String midChar = "";
            for (Character c : charSet) {
                midChar += c;
            }
            if (midChar.length() != 0 && firstHalf.size() == 0) {
                result.add(midChar);
            } else {
                for (String half : firstHalf) {
                    String palindrome = half + midChar;
                    for (int i = half.length() - 1; i >= 0; i--) {
                        palindrome += half.charAt(i);
                    }
                    result.add(palindrome);
                }
            }
        }
        return result;
    }
    
    public void permutations(char[] s, int index, List<String> permu) {
        if (index == s.length - 1) {
            permu.add(new String(s));
        } else {
            Set<Character> appeared = new HashSet<Character>();
            for (int i = index; i < s.length; i++) {
                if (appeared.add(s[i])) {
                    swap(s, i, index);
                    permutations(s, index + 1, permu);
                    swap(s, i, index);
                }
            }
        }
    }
    
    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
