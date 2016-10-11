import edu.duke.*;
import java.io.*;
/**
 * Write a description of ImageSaver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageSaver {
    public void doSave(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            String fname= image.getFileName();
            String newName = "copy-"+fname;
            //System.out.println(newName);
            image.setFileName(newName);
            image.draw();
            image.save();
        }
        
    }
}
