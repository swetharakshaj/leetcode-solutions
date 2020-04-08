//package ActualInterview;
//
//import java.io.*;
//import java.security.MessageDigest;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//public class VisaFileProcessing {
//
//
//
//
//
///*
//Let's say we want to write a function that scans a given filepath and prints all files whose contents are exactly the same.
//This function should take in a root directory and it should check all files in all subdirectories.
//The output can be printed as sets of matching files or as pairs (see example).
//We want it to be efficient, it needs to be 100% correct, and should be able to handle filesystems on the order of hundreds of GB.
//
//Example:
//If the following files all have the same content:
///home/files/draft.txt
///home/reports/drafts/metrics.txt
///home/deliverables/report.csv
//
//Calling:
//printDuplicateFiles(“/home”)
//
//Should print:
//
///home/files/draft.txt /home/reports/drafts/metrics.txt /home/deliverables/report.csv
//
//OR
//
///home/files/draft.txt /home/reports/drafts/metrics.txt
///home/files/draft.txt /home/deliverables/report.csv
///home/reports/drafts/metrics.txt /home/deliverables/report.csv
//*/
//
//
//        List<String> filePaths = new ArrayList<>();
//    /*
//    Map<String, List<String>> map
//
//    1. Helper to recursively read all file names in the path
//    2. Read contents of the file @ filepath and save to map.
//
//    * hash file content if files are large
//
//
//
//    */
//
//        private static void addFilePaths(String root) {
//            File rootFolder = new File(root);
//
//            for(File file : rootFolder.listFiles())
//            {
//                // directory
//                if(file.isDirectory())
//                {
//                    addFilePaths(root+"/"+file);
//                }
//                else if(file.isFile())
//                {
//                    String filePath = root+"/"+file.getName();
//                    filePaths.add(filePath);
//                }
//            }
//        }
//
//        private static List<List<String>> groupDuplicateFiles(String root)
//        {
//            Map<String, List<String>> contentFilePathMap = new HashMap<>();
//
//            // Read files from root
//
//            addFilePaths(root);
//
//            for(String file : filePaths)
//            {
//                // String data = new String(Files.readAllBytes(Paths.get(file));
//
//                MessageDigest md = MessageDigest.getInstance("MD5");
//
//                String data = checkSum(md, file);
//
//                if(contentFilePathMap.cotainsKey(data))
//                {
//                    contentFilePathMap.put(data, contentFilePathMap.get(contentFilePathMap).add(file));
//                }
//                else {
//                    List<String> filePaths = new ArrayList<>();
//                    filePaths.add(file);
//                    contentFilePathMap.put(data, filePaths);
//                }
//            }
//
//            return contentFilePathMap.values();
//
//        }
//        public static void main(String args[] ) throws Exception {
//            System.out.println("Hello World");
//        }
//
//}
