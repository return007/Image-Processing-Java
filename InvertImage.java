import java.io.*;
import java.awt.Image;
import javax.imageio.*;
import java.awt.image.BufferedImage;

public class InvertImage{

	private BufferedImage img;
	private BufferedImage newImage;
	private String fileName;
	private int height,width;


	public InvertImage(String inp){
		fileName = inp;
	}

	public void loadImage(){

		try{
			img = ImageIO.read(new File(fileName));
			height = img.getHeight();
			width = img.getWidth();
			newImage = new BufferedImage(height,width,BufferedImage.TYPE_INT_RGB);
		}
		catch(Exception e){
			System.out.println(e);
			System.exit(0);
		}
	}

	public void invert(){
		int i,j;
		try{
			File fout = new File(fileName.substring(0,fileName.lastIndexOf("."))+"-inverted"+".jpg");
			for(i=0;i<height;i++){
				for(j=0;j<width;j++){
					newImage.setRGB(width-1-j,height-1-i,img.getRGB(j,i));
				}
			}

			ImageIO.write(newImage,"jpg",fout);
		}
		catch(Exception e){
			System.out.println(e);
			System.exit(0);
		}
	}

	public static void main(String args[]){
		if(args.length == 1){
			System.out.println("Inverting Image!!! Please wait.");
		}
		else{
			System.out.println("Invalid arguments!!!");
			System.exit(0);
		}
		InvertImage ii = new InvertImage(args[0]);
		ii.loadImage();
		ii.invert();
	}
}