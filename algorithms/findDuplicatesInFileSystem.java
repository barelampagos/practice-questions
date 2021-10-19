/**
Given a list paths of directory info, including the directory path, and all the files with contents in this directory, return all the duplicate files in the file system in terms of their paths. You may return the answer in any order.

A group of duplicate files consists of at least two files that have the same content.

A single directory info string in the input list has the following format:

"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
It means there are n files (f1.txt, f2.txt ... fn.txt) with content (f1_content, f2_content ... fn_content) respectively in the directory "root/d1/d2/.../dm". Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.

The output is a list of groups of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. A file path is a string that has the following format:

"directory_path/file_name.txt"

Example 1:
Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
Output: [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]

Example 2:
Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"]
Output: [["root/a/2.txt","root/c/d/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 */
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> duplicates = new ArrayList<List<String>>();
        HashMap<String, List<String>> contentMap = new HashMap<>();   // K: File contents, V: File path (full)
        
        // Each directory
        for (String path : paths) {
            String[] splitPath = path.split(" ");
            String root = splitPath[0];
            
            // Each file in directory
            for (int i = 1; i < splitPath.length; i++) {
                // Obtain contents
                String[] current = splitPath[i].split("\\(");
                String fileName = current[0];
                String contents = current[1].replaceAll("\\)", "");
                
                if (contentMap.containsKey(contents)) {
                    List<String> contentPaths = contentMap.get(contents);
                    contentPaths.add(root + "/" + fileName);
                    contentMap.put(contents, contentPaths);
                } else {
                    List<String> contentPaths = new ArrayList<>();
                    contentPaths.add(root + "/" + fileName);
                    contentMap.put(contents, contentPaths);
                }
            }
        }
        
        for (String content : contentMap.keySet()) {
            List<String> contentPaths = contentMap.get(content);
            
            if (contentPaths.size() > 1) {
                duplicates.add(contentPaths);
            }
        }
        
        return duplicates;
    }
}