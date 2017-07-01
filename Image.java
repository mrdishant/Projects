package com.nearur;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Image extends JFrame{
	BufferedImage myPicture;
	JLabel picLabel;
	public Image() {
    	
		try {
			myPicture = ImageIO.read(new File("C:/Users/mrdis/Downloads/image.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 picLabel= new JLabel(new ImageIcon(myPicture));
	}
	
	
	
	public JLabel getPicLabel() {
		return picLabel;
	}



	public void setPicLabel(JLabel picLabel) {
		this.picLabel = picLabel;
	}



	public static void main(String[] nt) {
	}
}
