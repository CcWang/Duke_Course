import edu.duke.*;
import java.io.*;

public class converImageToGray(){

	public ImageResource makeGray(ImageResource inImage){
	// new image called outImage, using inImage's width and height
		ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
	// covert each pixel
		for (Pixel pixel : outImage.pixels()) {
		 	// get pixel from inImage
		 	// getPixel(int x,int y)
		 	Pixel inPixel=inImage.getPixel(pixel.getX(),pixel.getY());
		 	int averageColor = (inPixel.getRed()+inPixel.getBlue()+inPixel.getGreen())/3
		 	// set outImage pixel color
		 	pixel.setRed(averageColor);
		 	pixel.setBlue(averageColor);
		 	pixel.setGreen(averageColor);
		 }
		return outImage;
	}
// select and convert and save
	public void newGray(){
		DirectoryResource dr = new DirectoryResource();
		for(File f:dr.selectedFiles){
			ImageResource inImage=new ImageResource(f);
			ImageResource outImage = makeGray(inImage);
			String inImageName = inImage.getFileName();
			String outImageName ="gray-"+inImageName;
			outImage.draw();
			outImage.save();
		}
	}
}