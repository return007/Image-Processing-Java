import java.io.*;
import javax.imageio.*;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class RandomImage extends JPanel{
	
	private BufferedImage img;
	
	@Override
	public void paint(Graphics g){
		createImage();
		g.drawImage(img,0,0,this);
	}
	
	public int getRand(){
		int x = (int)(Math.random()*1000);
		return x%256;
	}
	
	public void createImage(){
		img = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
		int i,j;
		
		int height,width;
		height = img.getHeight();
		width = img.getWidth();
		
		for(i=0;i<height;i++){
			for(j=0;j<width;j++){
				Color newColor = new Color(getRand(), getRand(), getRand());
				img.setRGB(i,j,newColor.getRGB());
			}
		}
	}
	
	
	public static void main(String args[]){
		JFrame jf = new JFrame("Random Image Generation");
		jf.setSize(500,500);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jf.getContentPane().add(new RandomImage());
	}
}
