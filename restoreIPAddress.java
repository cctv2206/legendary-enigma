/**

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

*/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        int[] addr = new int[4];
        
        ipAddrHelper(result, addr, 0, s, 0);
        
        return result;
    }
    
    public void ipAddrHelper(List<String> result, int[] addr, int pos,  String s, int index) {
        
        if (pos == 4 && index == s.length()) {
            result.add(addr[0] + "." + addr[1] + "." + addr[2] + "." + addr[3]);
            return;
        }
        
        if (pos == 4 || index == s.length()) {
            return;
        }
        
        for (int i = 1; i < 4 && index + i <= s.length(); i++) {
            
            String newAddr = s.substring(index, index + i);
            int num = Integer.parseInt(newAddr);
            if (num > 255 || (i > 1 && newAddr.charAt(0) == '0')) {
                break;
            }
            addr[pos] = num;
            
            ipAddrHelper(result, addr, pos + 1, s, index + i);
        }
    }
}
