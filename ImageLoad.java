import java.io.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.*;

public class ImageLoad{
	
	private BufferedImage img;
	
	private void loadImage(){
		try{
			img = ImageIO.read(new File("sample.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
			System.exit(0);
		}
		int[] pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
	}
	
	public static void main(String args[])throws IOException{
		ImageLoad obj = new ImageLoad();
		obj.loadImage();
	}
}
