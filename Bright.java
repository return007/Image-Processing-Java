import java.io.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.awt.Color;

public class Bright{

	private BufferedImage img;
	private int height,width;
	private int scale;
	private String name;

	public Bright(String str, int a){
		name = str;
		scale = a;
	}

	public void loadImage(){
		try{
			img = ImageIO.read(new File(name));
			height = img.getHeight();
			width = img.getWidth();
		}
		catch(Exception e){
			System.out.println(e);
			System.exit(0);
		}
	}

	public void brightens(){
		int i,j;
		try{
			File fout = new File(name.substring(0,name.lastIndexOf("."))+"-brighten.jpg");
			for(i=0;i<height;i++){
				for(j=0;j<width;j++){
					Color c = new Color(img.getRGB(j,i));
					int r = c.getRed();
					int b = c.getBlue();
					int g = c.getGreen();

					int nr = (int)(r + 15.5*scale);
					int nb = (int)(b + 15.5*scale);
					int ng = (int)(g + 15.5*scale);

					nr = Math.min(nr,255);
					ng = Math.min(ng,255);
					nb = Math.min(nb,255);

					Color nc = new Color(nr,ng,nb);
					img.setRGB(j,i,nc.getRGB());
				}
			}

			ImageIO.write(img,"jpg",fout);
		}
		catch(Exception e){
			System.out.println(e);
			System.exit(0);
		}
	}

	public static void main(String args[]){
		int y = 0;
		if(args.length == 2){
			try{
				y = Integer.parseInt(args[1]);
				System.out.println("Applying changes.... Please Wait");
			}
			catch(Exception e){
				System.out.println("Invalid Parameters!!! Please try again");
				System.exit(0);
			}
		}
		else{
			System.out.println("Invalid Parameters!!! Please try again");
			System.exit(0);
		}
		Bright b = new Bright(args[0],y);
		b.loadImage();
		b.brightens();
	}
}