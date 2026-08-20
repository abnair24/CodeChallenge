package com.abn.design.leetcode;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
// Sample Input 1
paths = ["root/a 4.txt(xyz) 1.txt(algorithms)","root/c 3.txt(educative)","root/c/d 2.txt(algorithms)",
"root 4.txt(educative) 5.txt(abcd)"]

// Sample Input 2
paths = ["root 1.txt(abcd) 2.txt(algo)","root/a 2.txt(abcd)","root/c/d 4.txt(algo)"]

// Sample Input 3
paths = ["root 1.txt(abcd) 2.txt(algo)","root/a 2.txt(xyzc)","root/c/d 4.txt(educative)"]

// Sample Output 1
[["root/a/1.txt","root/c/d/2.txt"],["root/c/3.txt","root/4.txt"]]

// Sample Output 2
[["root/2.txt","root/c/d/4.txt"],["root/1.txt","root/a/2.txt"]]

// Sample Output 3
[]
 */

@Data
class FileNode {

    String fileName;
    String fileContent;
    String directory;

}
public class FindDuplicatesInSystem {

    public List<List<String>> findDuplicatesFilesByContent(String[] paths) {

        Map<String, List<String>> contentToFileMap = new HashMap<>();

        for(String parts : paths) {
            FileNode node = new FileNode();
            String[] directoryContent = parts.split(" ");
            node.setDirectory(directoryContent[0]);
            for(int i = 1; i < directoryContent.length; i++) {
                String[] fileNameContent = directoryContent[i].split("\\(");
                node.setFileName(fileNameContent[0]);
                node.setFileContent(fileNameContent[1].substring(0, fileNameContent[1].length() -1));

                List<String> files;

                if(!contentToFileMap.containsKey(node.fileContent)) {
                    files = new ArrayList<>();
                } else {
                    files = contentToFileMap.get(node.fileContent);
                }
                files.add(node.directory + "/" + node.fileName);
                contentToFileMap.put(node.fileContent, files);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry : contentToFileMap.entrySet()) {
            if(entry.getValue().size() > 1) {
                result.add(entry.getValue());
            }
        }

        return result;
    }

    public static void main(String[] args) {

        FindDuplicatesInSystem findDuplicatesInSystem = new FindDuplicatesInSystem();
        String[] paths = {"root/a 4.txt(xyz) 1.txt(algorithms)","root/c 3.txt(educative)","root/c/d 2.txt(algorithms)",
                "root 4.txt(educative) 5.txt(abcd)"};

        System.out.println(findDuplicatesInSystem.findDuplicatesFilesByContent(paths));
    }

}
