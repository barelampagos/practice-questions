/** NOTE: Does not pass all test cases
Suppose we have a file system that stores both files and directories. 

Here, we have dir as the only directory in the root. dir contains two subdirectories, subdir1 and subdir2. subdir1 contains a file file1.ext and subdirectory subsubdir1. subdir2 contains a subdirectory subsubdir2, which contains a file file2.ext.

In text form, it looks like this (with ⟶ representing the tab character):

dir
⟶ subdir1
⟶ ⟶ file1.ext
⟶ ⟶ subsubdir1
⟶ subdir2
⟶ ⟶ subsubdir2
⟶ ⟶ ⟶ file2.ext

If we were to write this representation in code, it will look like this: 
"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext". 
Note that the '\n' and '\t' are the new-line and tab characters.

Every file and directory has a unique absolute path in the file system, which is the order of directories that must be opened to reach the file/directory itself, all concatenated by '/'s. Using the above example, the absolute path to file2.ext is "dir/subdir2/subsubdir2/file2.ext". Each directory name consists of letters, digits, and/or spaces. Each file name is of the form name.extension, where name and extension consist of letters, digits, and/or spaces.

Given a string input representing the file system in the explained format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.

 */

class Solution {
    public int lengthLongestPath(String input) {
        int maxLengthPath = 0;
        int currDepth = -1;
        
        String[] separateLine = input.split("\n");
        //System.out.println(Arrays.toString(separateLine));
        
        List<String> path = new ArrayList<>();
        
        for (String s : separateLine) {
            int depth = 0;
            //System.out.println(s);
            
            for (Character c : s.toCharArray()) {
                if (c == '\t') {
                    depth++;
                }
            }
            
            //System.out.println(depth);
            
            // Case: File exists in folder
            if (depth > currDepth) {
                path.add(s.replace("\t", ""));
                currDepth = depth;
            } 
            // Case: Evaluating a level higher (..)
            else if (depth < currDepth) {
                path.remove(currDepth);
                currDepth = depth;
            } 
            // Case: Evaluating a diff directory in same folder
            else {
                path.set(depth, s.replace("\t", ""));
            }
            
            // Only calculate path length if any files exist (excluding main directory)
            if (path.size() > 1) {
                String currPath = path.stream().collect(Collectors.joining("/"));
                if (currPath.length() > maxLengthPath) {
                    maxLengthPath = currPath.length();
                }
            }
            
            //System.out.println(path.toString());
        }
        
        return maxLengthPath;
    }
}