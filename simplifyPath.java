/**

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".

*/

public class Solution {
    public String simplifyPath(String path) {
        char[] charArray = path.toCharArray();
        List<String> newPath = new ArrayList<String>();
        int length = path.length();
        String filename = "";
        int start;
        
        for (int i = 0; i < length; i++) {
            if (charArray[i] == '/' ) {
                continue;
            }
            
            start = i;
            while (i < length && charArray[i] != '/') {
                i++;
            }
            filename = path.substring(start, i);
            
            if (filename.equals("..")) { // name = ..
                if (newPath.size() != 0) {
                    newPath.remove(newPath.size() - 1);
                }
            } else if (!filename.equals(".")) { // some name
                newPath.add(filename);
                filename = "";
            }
        }
        
        if (newPath.size() == 0) {
            return "/";
        }
        
        StringBuilder res = new StringBuilder();
        for (String name : newPath) {
            res.append("/").append(name);
        }
        
        return res.toString();
    }
}


public class Solution {
    public String simplifyPath(String path) {
        Stack<String> newPath = new Stack<String>();
        String[] filenames = path.split("/");
        for (String name : filenames) {
            if (name.equals("") || name.equals(".")) {
                continue;
            }
            if (name.equals("..")) {
                if (!newPath.isEmpty()) {
                    newPath.pop();
                }
            } else {
                newPath.push(name);
            }
        }
        
        if (newPath.isEmpty()) {
            return "/";
        }
        
        List<String> list = new ArrayList<String>(newPath);
        StringBuilder res = new StringBuilder();
        for (String name : list) {
            res.append("/").append(name);
        }
        
        return res.toString();
    }
}
