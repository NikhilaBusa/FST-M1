package activities;
import java.io.File;
import java.io.IOException;
import java.util.*;
import org.apache.commons.io.FileUtils;


public class Activity14 {
    public static void main(String[] args) throws IOException
    {
        try
        {
            File file = new File("src/main/resources/activity14.txt");
            boolean fStatus = file.createNewFile();
            System.out.println("File already exists? " + !fStatus);

            File fileUtil = FileUtils.getFile("src/main/resources/activity14.txt");
            System.out.println("Text in file: " + FileUtils.readFileToString(fileUtil,"UTF-8"));

            File newDir = new File("src/main/rsrcs");
            FileUtils.copyFileToDirectory(file, newDir);
            File newFile = FileUtils.getFile(newDir, "activity14.txt");
            System.out.println("Text in new file: " + FileUtils.readFileToString(newFile,"UTF-8"));
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

    }

}
