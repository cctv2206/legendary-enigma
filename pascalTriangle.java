/**
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) return res;
        List<Integer> lastRow = new ArrayList<Integer>();
        lastRow.add(1);
        res.add(lastRow);
        while (numRows > 1) {
            
            List<Integer> thisRow = new ArrayList<Integer>();
            thisRow.add(1);
            for (int i = 1; i < lastRow.size(); i++) {
                thisRow.add(lastRow.get(i - 1) + lastRow.get(i));
            }
            thisRow.add(1);
            
            res.add(thisRow);
            
            lastRow = thisRow;
            
            numRows--;
        }
        return res;
    }
}
