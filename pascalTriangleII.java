/**
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastRow = new ArrayList<Integer>();
        if (rowIndex < 0) return lastRow;
        
        lastRow.add(1);
        
        while (rowIndex > 0) {
            List<Integer> thisRow = new ArrayList<Integer>();
            
            thisRow.add(1);
            for (int i = 1; i < lastRow.size(); i++) {
                thisRow.add(lastRow.get(i - 1) + lastRow.get(i));
            }
            thisRow.add(1);
            
            lastRow = thisRow;
            
            rowIndex--;
        }
        return lastRow;
        
    }
}

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] row = new int[rowIndex + 1];
        row[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            row[i] = (int) (((long) row[i - 1] * (rowIndex - i + 1)) / i);
        }
        
        List<Integer> res = new ArrayList<Integer>();
        for (int num : row) {
            res.add(num);
        }
        
        return res;
    }
}
