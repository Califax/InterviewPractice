package CompanyQuestions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.glassdoor.com/Interview/Find-all-duplicate-files-by-content-in-your-filesystem-QTN_899091.htm
public class FindDuplicateFiles {

    /*
    Not Done
     */
    private static final String PATH = "/Users/kevinjohnstone/IdeaProjects/interviewpractice/src/main/java/CompanyQuestions";
    List<File> fileList = new ArrayList<>();

    public void init() {
        File parent = new File(PATH + "/parent");
        File child1 = new File(parent, "child1");
        File child2 = new File(parent, "child2");

        Collections.addAll(fileList, parent, child1, child2);

//        System.out.println(parent.isDirectory());
//        System.out.println(parent.isFile());
//        System.out.println(child1.exists());

        for (File file : fileList) {
            try {
                file.createNewFile();
                if (file.getAbsolutePath().equals(PATH + "/parent")) {
                    boolean mkdirs = file.mkdirs();
                    System.out.println("mkdirs = " + mkdirs);
                }
            } catch (IOException e) {
                System.out.println("error on file: " + file);
                e.printStackTrace();
            }
            System.out.println("file = " + file);
        }

        for (File file : fileList) {
            file.delete();
        }

    }

    List<File> findDuplicates(File root) {
        return null;
    }

    public static void main(String[] args) {
        FindDuplicateFiles obj = new FindDuplicateFiles();

        obj.init();
    }
}
