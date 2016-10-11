import edu.duke.*;
import java.io.*;
/**
 * Write a description of GrayScaleConverter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrayScaleConverter {
    //started with the image 
    public ImageResource makeGray(ImageResource inImage){
        //made a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        for (Pixel pixel:outImage.pixels()){
            // look at the corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
            //compute inPixel's red+ inPixel'blue+ inPixel'green
            //divide that sum by 3(get average);
            int average = (inPixel.getRed()+inPixel.getBlue()+inPixel.getGreen())/3;
            // set pixel's red to average
            pixel.setRed(average);
            //set pixel's green to average
            pixel.setBlue(average);
            //set pixel's blue to average
            pixel.setGreen(average);
            
        }
        return outImage;
        
    }
    
    public void testGray(){
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
    
    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeGray(inImage);
            gray.draw();
        }
    }
    
}
