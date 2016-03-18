/**

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters is just like on the telephone buttons.

Note that although the above answer is in lexicographical order, the answer could be in any order.

Interestingly enough, this puzzle is similar to the Generate Parentheses problem.

*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.equals("")) {
            return result;
        }
        
        String [][] digitToLetters = {{"a","b","c"}, {"d","e","f"}, {"g","h","i"}, {"j","k","l"}, {"m","n","o"}, {"p","q","r","s"}, {"t","u","v"}, {"w","x","y","z"}};
        int digitsLength = digits.length();
        result.add("");
        for (int i = 0; i < digitsLength; i++) {
            List<String> temp = new ArrayList<String>();
            int digit = digits.charAt(i) - '2';
            for (String resultString: result) {
                for (String letter: digitToLetters[digit]) {
                    temp.add(resultString + letter);
                }
            }
            result = temp;
        }
        return result;
    }
}
