/**
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

*/

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        if (rows == 0) {
            return 0;
        }
        if (rows == 1) {
            return triangle.get(0).get(0);
        }
        
        List<Integer> pathSumLastRow = new ArrayList<Integer>();
        pathSumLastRow.add(triangle.get(0).get(0));
        
        for (int row = 1; row < rows; row++) {
            List<Integer> thisRow = triangle.get(row);
            int length = thisRow.size();
            List<Integer> pathSumThisRow = new ArrayList<Integer>();
            
            pathSumThisRow.add(pathSumLastRow.get(0) + thisRow.get(0));
            for (int index = 1; index < length - 1; index++) {
                pathSumThisRow.add(thisRow.get(index) + Math.min(pathSumLastRow.get(index), pathSumLastRow.get(index - 1)));
            }
            pathSumThisRow.add(pathSumLastRow.get(length - 1 - 1) + thisRow.get(length - 1));
            
            pathSumLastRow = pathSumThisRow;
            
        }
        
        return Collections.min(pathSumLastRow);
        
    }
}


public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[] pathSum = new int[rows];
        
        pathSum[0] = triangle.get(0).get(0);
        
        for (int row = 1; row < rows; row++) {
            List<Integer> thisRow = triangle.get(row);
            
            // last one
            pathSum[row] = pathSum[row - 1] + thisRow.get(row);
            
            // middle
            for (int index = row - 1; index >0; index--) {
                pathSum[index] = thisRow.get(index) + Math.min(pathSum[index - 1], pathSum[index]);
            }
            
            // first one
            pathSum[0] = thisRow.get(0) + pathSum[0];
        }
        
        // find min
        int min = Integer.MAX_VALUE;
        for (int num : pathSum) {
            min = Math.min(num, min);
        }
    
        return min;
    }
}


public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        
        int[] lastRow = new int[triangle.size()];
        int[] thisRow = new int[triangle.size()];
        
        lastRow[0] = triangle.get(0).get(0);
        
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            thisRow[0] = lastRow[0] + row.get(0);
            for (int j = 1; j < row.size() - 1; j++) {
                thisRow[j] = row.get(j) + Math.min(lastRow[j], lastRow[j - 1]);
            }
            thisRow[row.size() - 1] = lastRow[row.size() - 2] + row.get(row.size() - 1);
            
            int[] temp = thisRow;
            thisRow = lastRow;
            lastRow = temp;
        }
        
        int res = Integer.MAX_VALUE;
        for (int num : lastRow) {
            if (num < res) res = num;
        }
        
        return res;
    }
}
